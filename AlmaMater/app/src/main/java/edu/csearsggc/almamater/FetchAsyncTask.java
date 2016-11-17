package edu.csearsggc.almamater;

import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by Caleb Sears on 11/8/2016.
 */

class FetchAsyncTask extends AsyncTask<Integer, Void, String> {

    private TextView noteFound;

    FetchAsyncTask(TextView _noteFound) {
        noteFound = _noteFound;
    }

    @Override
    protected String doInBackground(Integer... integers) {

        int midi = integers[0];

        MidiNote midiNote = new MidiNote(midi);

        return midiNote.getNote();
    }

    @Override
    protected void onPostExecute(String aNote) {
        super.onPostExecute(aNote);
        noteFound.setText(aNote);
    }
}
