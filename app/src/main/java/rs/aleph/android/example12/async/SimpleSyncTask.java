package rs.aleph.android.example12.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import rs.aleph.android.example12.fragments.ListFragment;

public class SimpleSyncTask extends AsyncTask<Void, Void, Void> {

    private Activity activity;
    private ListFragment.OnItemSelectedListener listener;

    public SimpleSyncTask(Activity activity) {
        this.activity = activity;
        listener = (ListFragment.OnItemSelectedListener) activity;
        }


    @Override
    protected void onPreExecute() {
        }


    @Override
    protected Void doInBackground(Void... params) {
        try {
        //simulacija posla koji se obavlja u pozadini i traje duze vreme
        Thread.sleep(3000);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }

        return null;
        }


    @Override
    protected void onPostExecute(Void products) {
        Toast.makeText(activity, "Sync done", Toast.LENGTH_SHORT).show();
        }
}

