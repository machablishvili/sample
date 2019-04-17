package ge.neso.info08.managers;

import android.content.Context;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ge.neso.info08.conn.MyServerParams;
import ge.neso.info08.conn.ResponseHandler;
import ge.neso.info08.conn.ServerConnection;
import ge.neso.info08.models.TransportScheduleDetailsItem;
import ge.neso.info08.models.TransportScheduleItem;

public class TransportationManager {

    private static final String TAG = "TransportationManager";

    public interface TransportTypeHandler {

        public void onSuccess(List<TransportType> items);

        public void onError(int errorCode);
    }

    public interface TransportScheduleHandler {

        public void onSuccess(TransportScheduleItem item);

        public void onError(int errorCode);
    }

    public interface TransportScheduleDetailsHandler {

        public void onSuccess(TransportScheduleDetailsItem item);

        public void onError(int errorCode);
    }

    public interface TownsHandler {

        public void onSuccess(List<Town> items);

        public void onError(int errorCode);
    }


    public static void getTransportTypes(Context context, String url, final TransportationManager.TransportTypeHandler handler) {


        ServerConnection serverConnection = MyServerParams.getConnection();
        Map<String, String> params = new HashMap<>();

        serverConnection.getRequest(context, url, params, new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                try {

                    JSONArray exchangeArray = new JSONArray(result);
                    List<TransportType> list = new ArrayList<>();

                    ObjectMapper mapper = new ObjectMapper();
                    if (exchangeArray != null) {
                        for (int i = 0; i < exchangeArray.length(); i++) {
                            JSONObject obj = exchangeArray.getJSONObject(i);

                            try {
                                TransportType transportItem = mapper.readValue(obj.toString(), TransportType.class);
                                list.add(transportItem);
                            } catch (IOException e) {
                                Log.d(TAG, "TRANSPORT TYPE casting error:" + e.toString());
                            }
                        }
                        Log.d(TAG, "WE ARE IN TRANSPORT TYPES " + list.size());
                    }

                    // handle success
                    if (handler != null) {
                        handler.onSuccess(list);
                    }
                } catch (JSONException e) {
                    Log.d(TAG, "parsing user code error: " + e.toString());
                    // show error message
                    if (handler != null) {
                        handler.onError(-1);
                    }
                }

            }

            @Override
            public void onError(int errorCode) {
                handler.onError(errorCode);
            }
        });

    }

    public static void getTransportSchedule(Context context, String url, final TransportationManager.TransportScheduleHandler handler) {


        ServerConnection serverConnection = MyServerParams.getConnection();
        Map<String, String> params = new HashMap<>();

        serverConnection.getRequest(context, url, params, new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                try {

                    JSONObject transportObject = new JSONObject(result);

                    TransportScheduleItem item = new TransportScheduleItem();

                    ObjectMapper mapper = new ObjectMapper();
                    if (transportObject != null) {

                        try {
                            item = mapper.readValue(transportObject.toString(), TransportScheduleItem.class);

                        } catch (IOException e) {
                            Log.d(TAG, "TRANSPORT SCHEDULE casting error:" + e.toString());
                        }

                        Log.d(TAG, "WE ARE IN TRANSPORT SCHEDULE " + item.getNextPageUrl());
                    }

                    // handle success
                    if (handler != null) {
                        handler.onSuccess(item);
                    }
                } catch (JSONException e) {
                    Log.d(TAG, "parsing user code error: " + e.toString());
                    // show error message
                    if (handler != null) {
                        handler.onError(-1);
                    }
                }

            }

            @Override
            public void onError(int errorCode) {
                handler.onError(errorCode);
            }
        });

    }

    public static void getTransportScheduleDetails(Context context, String url, final TransportationManager.TransportScheduleDetailsHandler handler) {


        ServerConnection serverConnection = MyServerParams.getConnection();
        Map<String, String> params = new HashMap<>();

        serverConnection.getRequest(context, url, params, new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                try {

                    JSONObject scheduleDetails = new JSONObject(result);

                    TransportScheduleDetailsItem item = new TransportScheduleDetailsItem();

                    ObjectMapper mapper = new ObjectMapper();
                    if (scheduleDetails != null) {

                        try {
                            item = mapper.readValue(scheduleDetails.toString(), TransportScheduleDetailsItem.class);
                        } catch (IOException e) {
                            Log.d(TAG, "TRANSPORT SCHEDULE DETAILS casting error:" + e.toString());
                        }

                        Log.d(TAG, "WE ARE IN TRANSPORT SCHEDULE DETAILS " + item.getSchedule().size());
                    }

                    // handle success
                    if (handler != null) {
                        handler.onSuccess(item);
                    }
                } catch (JSONException e) {
                    Log.d(TAG, "parsing transport code error: " + e.toString());
                    // show error message
                    if (handler != null) {
                        handler.onError(-1);
                    }
                }

            }

            @Override
            public void onError(int errorCode) {
                handler.onError(errorCode);
            }
        });

    }

    public static void getTowns(Context context, String url, final TransportationManager.TownsHandler handler) {


        ServerConnection serverConnection = MyServerParams.getConnection();
        Map<String, String> params = new HashMap<>();

        serverConnection.getRequest(context, url, params, new ResponseHandler() {
            @Override
            public void onSuccess(String result) {
                try {

                    JSONArray myArray = new JSONArray(result);
                    List<Town> list = new ArrayList<>();

                    ObjectMapper mapper = new ObjectMapper();
                    if (myArray != null) {
                        for (int i = 0; i < myArray.length(); i++) {
                            JSONObject obj = myArray.getJSONObject(i);

                            try {
                                Town itemTown = mapper.readValue(obj.toString(), Town.class);
                                list.add(itemTown);
                            } catch (IOException e) {
                                Log.d(TAG, "TOWN casting error:" + e.toString());
                            }
                        }
                        Log.d(TAG, "WE ARE IN TOWNS " + list.size());
                    }

                    // handle success
                    if (handler != null) {
                        handler.onSuccess(list);
                    }
                } catch (JSONException e) {
                    Log.d(TAG, "parsing town code error: " + e.toString());
                    // show error message
                    if (handler != null) {
                        handler.onError(-1);
                    }
                }

            }

            @Override
            public void onError(int errorCode) {
                handler.onError(errorCode);
            }
        });

    }
}
