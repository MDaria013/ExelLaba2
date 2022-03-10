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


    private void geometric(double[][] arr) {
        Double[] geometric = new Double[3];
        for (int i = 0; i < 3; i++) {
            geometric[i] = StatUtils.geometricMean(arr[i]);
        }
        lhm.put("Среднее геометрическое", geometric);
    }

    private void mean(double[][] arr) {
        Double[] mean = new Double[3];
        for (int i = 0; i < 3; i++) {
            mean[i] = StatUtils.mean(arr[i]);
        }
        lhm.put("Среднее арифметическое", mean);
    }

    private void variance(double[][] arr) {
        Double[] variance = new Double[3];
        for (int i = 0; i < 3; i++) {
            variance[i] = Math.sqrt(StatUtils.variance(arr[i]));
        }
        lhm.put("Стандартное отклонение", variance);
    }

    private void samplesize(double[][] arr) {
        Double[] samplesize = new Double[3];
        for (int i = 0; i < 3; i++) {
            samplesize[i] = StatUtils.max(arr[i]) - StatUtils.min(arr[i]);
        }
        lhm.put("Размах выборки", samplesize);
    }

    private void covariance(double[][] arr) {
        Double[] covariance = new Double[3];
        covariance[0] = new Covariance().covariance(arr[0], arr[1]);
        covariance[1] = new Covariance().covariance(arr[0], arr[2]);
        covariance[2] = new Covariance().covariance(arr[1], arr[2]);
        lhm.put("Коэффициент ковариации", covariance);
    }

    private void size(double[][] arr) {
        Double[] size = new Double[3];
        for (int i = 0; i < 3; i++) {
            size[i] = (double) arr[i].length;
        }
        lhm.put("Количество элементов", size);
    }

    private void variation(double[][] arr) {
        Double[] variation = new Double[3];
        for (int i = 0; i < 3; i++) {
            variation[i] = Math.sqrt(StatUtils.variance(arr[i])) / Math.abs(StatUtils.mean(arr[i]));
        }
        lhm.put("Коэффициент вариации", variation);
    }

    private void confidenceintervalpl(double[][] arr) {
        Double[] confidenceintervalpl = new Double[3];
        for (int i = 0; i < 3; i++) {
            confidenceintervalpl[i] = StatUtils.mean(arr[i]) + (new TDistribution(arr[i].length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(arr[i]))) / Math.sqrt(arr[i].length);
        }
        lhm.put("Доверительный интервал+", confidenceintervalpl);
    }

    private void confidenceintervalm(double[][] arr) {
        Double[] confidenceintervalm = new Double[3];
        for (int i = 0; i < 3; i++) {
            confidenceintervalm[i] = StatUtils.mean(arr[i]) - (new TDistribution(arr[i].length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(arr[i]))) / Math.sqrt(arr[i].length);
        }
        lhm.put("Доверительный интервал-",confidenceintervalm);
    }

    private void dispersion(double[][] arr) {
        Double[] dispersion = new Double[3];
        for (int i = 0; i < 3; i++) {
            dispersion[i] = StatUtils.variance(arr[i]);
        }
        lhm.put("Оценка дисперсии", dispersion);
    }

    private void max(double[][] arr) {
        Double[] max = new Double[3];
        for (int i = 0; i < 3; i++) {
            max[i] = StatUtils.max(arr[i]);
        }
        lhm.put("Max", max);
    }

    private void min(double[][] arr) {
        Double[] min = new Double[3];
        for (int i = 0; i < 3; i++) {
            min[i] = StatUtils.min(arr[i]);
        }
        lhm.put("Min", min);
    }

    public void calculation(double[][] arr) {
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