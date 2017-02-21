from urllib2 import *
import urllib
import json
import sys

MY_API_KEY="AIzaSyA_Qj77o3yM875v_uFI7uCKJQbGsfpFA78"

messageTitle = "Notificacion"
messageBody = "Conseguido!!!!!"

data={
    "to" : "/topics/my_little_topic",
    "notification" : {
        "body" : messageBody,
        "title" : messageTitle,
        "icon" : "ic_input",
        "click_action" : "OPEN_ACTIVITY_2"
    }
}

dataAsJSON = json.dumps(data)

request = Request(
    "https://gcm-http.googleapis.com/gcm/send",
    dataAsJSON,
    { "Authorization" : "key="+MY_API_KEY,
      "Content-type" : "application/json"
    }
)

print urlopen(request).read()