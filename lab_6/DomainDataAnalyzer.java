import java.util.List;

public class DomainDataAnalyzer {
    public static void main(String[] args) {

        DataSet<Integer> songLengths = new DataSet<>();
        songLengths.add(185);
        songLengths.add(220);
        songLengths.add(170);
        songLengths.add(300);
        songLengths.add(245);

        System.out.println("----- Music Studio Analytics: Album Track Lengths -----");
        System.out.println("Track Lengths (seconds): " + songLengths.getData());

        Analysis<Integer> totalLength = data -> {
            int sum = 0;
            for (Integer val : data) {
                sum += val;
            }
            return sum;
        };

        Analysis<Integer> averageLength = data -> {
            if (data.isEmpty())
                return 0;
            int sum = 0;
            for (Integer val : data) {
                sum += val;
            }
            return (double) sum / data.size();
        };

        Analysis<Integer> longestTrack = data -> {
            Integer max = Integer.MIN_VALUE;
            for (Integer val : data) {
                if (val > max) {
                    max = val;
                }
            }
            return max;
        };

        System.out.println("Total Album Duration (seconds): " + songLengths.calculate(totalLength));
        System.out.println(
                "Average Track Duration (seconds): " + String.format("%.2f", songLengths.calculate(averageLength)));
        System.out.println("Longest Track (seconds): " + songLengths.calculate(longestTrack));
        System.out.println();

        DataSet<Integer> trackBPMs = new DataSet<>();
        trackBPMs.add(120);
        trackBPMs.add(128);
        trackBPMs.add(90);
        trackBPMs.add(140);
        trackBPMs.add(110);

        System.out.println("----- Music Studio Analytics: Tempo Analysis (Beats Per Minute) -----");
        System.out.println("Track BPMs: " + trackBPMs.getData());

        Analysis<Integer> averageBPM = data -> {
            if (data.isEmpty())
                return 0;
            int sum = 0;
            for (Integer val : data) {
                sum += val;
            }
            return (double) sum / data.size();
        };

        Analysis<Integer> fastestTrack = data -> {
            Integer max = Integer.MIN_VALUE;
            for (Integer val : data) {
                if (val > max) {
                    max = val;
                }
            }
            return max;
        };

        Analysis<Integer> slowestTrack = data -> {
            Integer min = Integer.MAX_VALUE;
            for (Integer val : data) {
                if (val < min) {
                    min = val;
                }
            }
            return min;
        };

        System.out.println("Average BPM: " + String.format("%.2f", trackBPMs.calculate(averageBPM)));
        System.out.println("Fastest Track (BPM): " + trackBPMs.calculate(fastestTrack));
        System.out.println("Slowest Track (BPM): " + trackBPMs.calculate(slowestTrack));
        System.out.println();

        System.out.println("----- Domain-Specific Evaluation -----");
        Evaluation<Integer> areTracksSimilarLength = (len1, len2) -> Math.abs(len1 - len2) <= 15;

        Integer track1 = songLengths.getData().get(0);
        Integer track2 = songLengths.getData().get(2);
        System.out.println("Are Track 1 (" + track1 + "s) and Track 3 (" + track2 + "s) similar in length? "
                + areTracksSimilarLength.evaluate(track1, track2));
    }
}
