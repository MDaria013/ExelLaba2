package com.company;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.Covariance;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Calculation {

    public LinkedHashMap<String, Double[]> lhm = new LinkedHashMap<>();

   /*1.	Рассчитать среднее геометрическое для каждой выборки
    2.	Рассчитать среднее арифметическое для каждой выборки
    3.	Рассчитать оценку стандартного отклонения для каждой выборки
    4.	Рассчитать размах каждой выборки
    5.	Рассчитать коэффициенты ковариации для всех пар случайных чисел
    6.	Рассчитать количество элементов в каждой выборке
    7.	Рассчитать коэффициент вариации для каждой выборки
    8.	Рассчитать для каждой выборки построить доверительный интервал для мат. ожидания (Случайные числа подчиняются нормальному закону распределения)
    9.	Рассчитать оценку дисперсии для каждой выборки
    10.	Рассчитать максимумы и минимумы для каждой выборки*/


    private void geometric(ArrayList<double[]> arr) {
        Double[] geometric = new Double[3];
        for (int i = 0; i < 3; i++) {
            geometric[i] = StatUtils.geometricMean(arr.get(i));
        }
        lhm.put("Среднее геометрическое", geometric);
    }

    private void mean(ArrayList<double[]> arr) {
        Double[] mean = new Double[3];
        for (int i = 0; i < 3; i++) {
            mean[i] = StatUtils.mean(arr.get(i));
        }
        lhm.put("Среднее арифметическое", mean);
    }

    private void variance(ArrayList<double[]> arr) {
        Double[] variance = new Double[3];
        for (int i = 0; i < 3; i++) {
            variance[i] = Math.sqrt(StatUtils.variance(arr.get(i)));
        }
        lhm.put("Стандартное отклонение", variance);
    }

    private void samplesize(ArrayList<double[]> arr) {
        Double[] samplesize = new Double[3];
        for (int i = 0; i < 3; i++) {
            samplesize[i] = StatUtils.max(arr.get(i)) - StatUtils.min(arr.get(i));
        }
        lhm.put("Размах выборки", samplesize);
    }

    private void covariance(ArrayList<double[]> arr) {
        Double[] covariance = new Double[3];
        covariance[0] = new Covariance().covariance(arr.get(0), arr.get(1));
        covariance[1] = new Covariance().covariance(arr.get(0), arr.get(2));
        covariance[2] = new Covariance().covariance(arr.get(1), arr.get(2));
        lhm.put("Коэффициент ковариации", covariance);
    }

    private void size(ArrayList<double[]> arr) {
        Double[] size = new Double[3];
        for (int i = 0; i < 3; i++) {
            size[i] = (double) arr.get(i).length;
        }
        lhm.put("Количество элементов", size);
    }

    private void variation(ArrayList<double[]> arr) {
        Double[] variation = new Double[3];
        for (int i = 0; i < 3; i++) {
            variation[i] = Math.sqrt(StatUtils.variance(arr.get(i))) / Math.abs(StatUtils.mean(arr.get(i)));
        }
        lhm.put("Коэффициент вариации", variation);
    }

    private void confidenceintervalpl(ArrayList<double[]> arr) {
        Double[] confidenceintervalpl = new Double[3];
        for (int i = 0; i < 3; i++) {
            confidenceintervalpl[i] = StatUtils.mean(arr.get(i)) + (new TDistribution(arr.get(i).length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(arr.get(i)))) / Math.sqrt(arr.get(i).length);
        }
        lhm.put("Доверительный интервал+", confidenceintervalpl);
    }

    private void confidenceintervalm(ArrayList<double[]> arr) {
        Double[] confidenceintervalm = new Double[3];
        for (int i = 0; i < 3; i++) {
            confidenceintervalm[i] = StatUtils.mean(arr.get(i)) - (new TDistribution(arr.get(i).length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(arr.get(i)))) / Math.sqrt(arr.get(i).length);
        }
        lhm.put("Доверительный интервал-",confidenceintervalm);
    }

    private void dispersion(ArrayList<double[]> arr) {
        Double[] dispersion = new Double[3];
        for (int i = 0; i < 3; i++) {
            dispersion[i] = StatUtils.variance(arr.get(i));
        }
        lhm.put("Оценка дисперсии", dispersion);
    }

    private void max(ArrayList<double[]> arr) {
        Double[] max = new Double[3];
        for (int i = 0; i < 3; i++) {
            max[i] = StatUtils.max(arr.get(i));
        }
        lhm.put("Max", max);
    }

    private void min(ArrayList<double[]> arr) {
        Double[] min = new Double[3];
        for (int i = 0; i < 3; i++) {
            min[i] = StatUtils.min(arr.get(i));
        }
        lhm.put("Min", min);
    }

    public void calculation(ArrayList<double[]> arr) {
        geometric(arr);
        mean(arr);
        variance(arr);
        samplesize(arr);
        covariance(arr);
        size(arr);
        variation(arr);
        confidenceintervalpl(arr);
        confidenceintervalm(arr);
        dispersion(arr);
        max(arr);
        min(arr);
    }
    public LinkedHashMap<String, Double[]> lhm(){
        return this.lhm;
    }
}