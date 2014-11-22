package com.example.sattas.myapplication;

import android.os.AsyncTask;
/**
 * Created by sattas on 11/17/2014.
 */
public class AlgoCompute extends AsyncTask<String, Void, Long> {
    private InteractiveArrayAdapter adapter;

    public void setAdapter(InteractiveArrayAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected Long doInBackground(String... algoType) {
       long startTime = System.nanoTime();
       bubbleSort();
       long endTime = System.nanoTime();
       return endTime - startTime;
    }

    private void bubbleSort() {
        int[] randomArray = new int[100];
        for(int i = 0; i < 100; ++i)
        {
            int rand = ((int)(Math.random() * 100)) + 1;
            randomArray[i] = rand;
        }

        //int[] randomArray= { 3,4,2,8,9,4,5 ,4,89,3,1,3};
        boolean done;
        do {
            done = true;
            int i = 0;
            for (int j = i; j < randomArray.length - 1; ++j) {
                int k = j +1;
                if (randomArray[j] > randomArray[k]) {
                    int temp = randomArray[k];
                    randomArray[k] = randomArray[j];
                    randomArray[j] = temp;
                    done = false;
                }
            }
        } while (!done);
        /*for(int i = 0; i < randomArray.length; ++i) {
            for (int j = i; j < randomArray.length - 1; ++j) {
                for (int k = j +1; k < randomArray.length - 1; ++k) {
                    if (randomArray[j] > randomArray[k]) {
                        int temp = randomArray[k + 1];
                        randomArray[k + 1] = randomArray[k];
                        randomArray[k] = temp;
                    }
                }
            }
        }*/

        return;
    }

    @Override
    protected void onPostExecute(Long result) {
        adapter.add(new AlgoDisplayRow("bubbleSort", result, result));
    }
}
