package cice.inapppurchasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cice.inapppurchasedemo.util.IabHelper;
import cice.inapppurchasedemo.util.IabResult;
import cice.inapppurchasedemo.util.Inventory;
import cice.inapppurchasedemo.util.Purchase;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "inappbilling";
    IabHelper mHelper;

    static final String ITEM_SKU = "android.test.purchased";

    Button pulsar, comprar;

    public void setPulsar(Button pulsar) {
        this.pulsar = pulsar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pulsar = (Button)findViewById(R.id.pulsar);
        comprar = (Button)findViewById(R.id.comprar);

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprar();
            }
        });


        String base64EncodedPublicKey =
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl39D1iUCSd/NsnRSRM8+dxGjpeWmWvl6IyV9E4LYN41j47D3MTj4IeIAydb0xFirl34FamU658/ZRTq3utVjXgZZZTKmh12AbjGnG86dAskAj6hv7TzSxj7J5AedKGJGAZ6b8UAXwEPj2brqo54F0lI3jIJ/31px3Y7Y1B4VIXQNEUSKa81DPq1gosEM0vaadQX2sAbRSuQWoAfWTKMUSPkowTkEhTNweCXmcsuZU8hEWINB7jbcQ8/yMA023ClA+7v2fHyTdcYHDYR5xbAYBOVGApmxqHvaXw37aFV6x/hUINS1mYsAmhIabHaoOm4edG7KfQZeG/vq+TWKCH5UVwIDAQAB";

        mHelper = new IabHelper(this, base64EncodedPublicKey);

        mHelper.startSetup(new
                                   IabHelper.OnIabSetupFinishedListener() {
                                       public void onIabSetupFinished(IabResult result)
                                       {
                                           if (!result.isSuccess()) {
                                               Log.d(TAG, "In-app Billing setup failed: " +
                                                       result);
                                           } else {
                                               Log.d(TAG, "In-app Billing is set up OK");
                                           }
                                       }
                                   });
    }

    public void comprar() {
        consumeItem ();
        Log.d(TAG, "comprar()...");

        /*
        mHelper.launchPurchaseFlow(this, ITEM_SKU, 10001,
                mPurchaseFinishedListener, "mypurchasetoken");
                */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data)
    {
        if (!mHelper.handleActivityResult(requestCode,
                resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener
            = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result,
                                          Purchase purchase)
        {
            if (result.isFailure()) {
                // Handle error
                return;
            }
            else if (purchase.getSku().equals(ITEM_SKU)) {
                consumeItem();
                pulsar.setEnabled(false);
            }

        }
    };

    public void consumeItem() {
        mHelper.queryInventoryAsync(mReceivedInventoryListener);
    }

    IabHelper.QueryInventoryFinishedListener mReceivedInventoryListener
            = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result,
                                             Inventory inventory) {


            if (result.isFailure()) {

            } else {
                mHelper.consumeAsync(inventory.getPurchase(ITEM_SKU),
                        mConsumeFinishedListener);
            }
        }
    };


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mHelper != null) mHelper.dispose();
        mHelper = null;
    }

    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener =
            new IabHelper.OnConsumeFinishedListener() {

                public void onConsumeFinished(Purchase purchase,
                                              IabResult result) {

                    if (result.isSuccess()) {

                        pulsar.setEnabled(true);
                    } else {
                        // handle error

                    }
                }
            };
}
