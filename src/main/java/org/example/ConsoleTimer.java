package org.example;
// import java.util.Scanner;
public class ConsoleTimer {
    private static final int PROGRESS_BAR_WIDTH = 50;

    /*
    public static int getValidTimerValue() {
        Scanner sc = new Scanner(System.in);
        int timer;
        while (true) {
            System.out.print("Допустимое значение таймера: ");
            try {
                timer = sc.nextInt();
                if (timer > 0) {
                    break;
                } else {
                    System.out.println("Таймер должен быть больше 0");
                }
            } catch (Exception e) {
                System.out.println("Введено недопустимое значение");
                sc.nextLine();
            }
        }
        sc.close();
        return timer;
    }
     */

    public static Thread startTimer(int timer){
        Thread thread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            long elapsedTime = 0;
            while (elapsedTime < timer * 1000) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
                elapsedTime = System.currentTimeMillis() - startTime;
                float progress = (float) elapsedTime / (timer * 1000);
                String progressBar = getProgressBar(progress);
                String countdownTimer = getCountdownTimer(timer, elapsedTime);
                System.out.print("\r" + progressBar + " " + countdownTimer);
            }
        });
        thread.start();
        return thread;
    }

    private static String getProgressBar(float progress) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int completed = (int) ((1 - progress) * PROGRESS_BAR_WIDTH);
        int remaining = PROGRESS_BAR_WIDTH - completed;
        for (int i = 0; i < completed; i++) {
            sb.append("\033[32m█\033[0m");
        }
        for (int i = 0; i < remaining; i++) {
            sb.append("\033[31m█\033[0m");
        }
        sb.append("]");
        return sb.toString();
    }
    private static String getCountdownTimer(int timer, long elapsedTime) {
        long remainingTime = timer * 1000 - elapsedTime;
        float remainingPercentage = (float) remainingTime / (timer * 1000) * 100;
        remainingPercentage = Math.round(remainingPercentage * 100) / 100f;
        remainingTime = remainingTime / 1000 + 1;
        return String.format("%02d:%02d (%.1f%%)", remainingTime / 60, remainingTime % 60, remainingPercentage);
    }
}