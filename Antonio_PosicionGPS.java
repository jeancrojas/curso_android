import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

public class PosicionGPS implements android.location.LocationListener {

	LocationManager locationManager = null;
	private static final int MILLISECONDS_PER_SECOND = 1000;
	public static final int UPDATE_INTERVAL_IN_SECONDS = 30;
	public static final int TOLERANCIA_COORDENADAS = 10; //metros
	private static final long UPDATE_INTERVAL = MILLISECONDS_PER_SECOND * UPDATE_INTERVAL_IN_SECONDS;
	
	@Override
	public void onLocationChanged(Location location) {
		
		String msg = "Updated Location: " +
                Double.toString(location.getLatitude()) + "," +
                Double.toString(location.getLongitude());
        Toast.makeText(Globals.mainContext, msg, Toast.LENGTH_SHORT).show();
        
		
	}

	public void init(Activity activity, Context contexto) {
		locationManager = (LocationManager) Globals.mainActivity.getSystemService(Context.LOCATION_SERVICE);
		if (ActivityCompat.checkSelfPermission(Globals.mainActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Globals.mainActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			return;
		}
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
		

		boolean isGPSActivated = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		if (!isGPSActivated) {
			Toast.makeText(contexto, "Debe activar el GPS para utilizar la app", Toast.LENGTH_LONG).show();
			activity.startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
		}
	}

	public void stop() {
		if (ActivityCompat.checkSelfPermission(Globals.mainActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Globals.mainActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			return;
		}
		locationManager.removeUpdates(this);
	}

	@Override
	public void onProviderDisabled(String arg0) {
		Toast.makeText(Globals.mainContext, "Debe activar el GPS para utilizar la app", Toast.LENGTH_LONG).show();
		Globals.mainActivity.startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
	
    public Location getLocation(){
    	if (locationManager==null) return null;
		try{
			Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			return location;
		}
		catch (SecurityException e){
			return null;
		}
    }
}
