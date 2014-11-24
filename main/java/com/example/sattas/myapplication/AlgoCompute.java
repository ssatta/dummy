package com.example.sattas.myapplication;

import android.os.AsyncTask;

import java.util.concurrent.TimeUnit;

/**
 * Created by sattas on 11/17/2014.
 */
public class AlgoCompute extends AsyncTask<String, Void, Long> {
    private InteractiveArrayAdapter adapter;
    private int[] randomArray;
    private String _algoType;

    public void setRandomArray(int[] randomArray) {
        this.randomArray = randomArray;
    }

    public void setAdapter(InteractiveArrayAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected Long doInBackground(String... algoType) {
       _algoType = algoType[0];
       long startTime = System.nanoTime();
       if(_algoType=="bubbleSort") {
          bubbleSort();
       }
       else if(_algoType=="insertionSort"){
          insertionSort();
       }
       else if(_algoType=="quickSort"){
           quickSort(0, randomArray.length-1);
       }
       long endTime = System.nanoTime();
       long duration = endTime - startTime;
       long durationInMs = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS);
       return durationInMs;
    }

    private void bubbleSort() {
        for (int i = 1; i < randomArray.length; i++) {
            for (int j = 0; j < randomArray.length-i; j++) {
                int k = j + 1;
                if (randomArray[j] > randomArray[k]) {
                    swap(k,j);
                }
            }
        }

        return;
    }

    private void insertionSort() {
        for (int i = 0; i < randomArray.length-1; i++) {
            for (int j = i+1; j >= 1; j--) {
                int k = j - 1;
                if (randomArray[j] < randomArray[k]) {
                    swap(k,j);
                }
            }
        }
        return;
    }

    private void quickSort(int left, int right) {
        if(left < right) {
            int p = partition(left, right);
            quickSort(left, p-1);
            quickSort(p+1, right);
        }
    }

    private int partition(int left, int right) {
        int pivot = (left+right)/2;
        swap(pivot,right);
        int store = left;
        for(int i = left; i < right; i++) {
            if(randomArray[i] <= randomArray[right]) {
                swap(i,store);
                store++;
            }
        }
        swap(right, store);
        return store;
    }

    private void swap(int k, int j) {
        int temp = randomArray[k];
        randomArray[k] = randomArray[j];
        randomArray[j] = temp;
    }

    @Override
    protected void onPostExecute(Long result) {
        adapter.add(new AlgoDisplayRow(_algoType, result, result));
    }
}
