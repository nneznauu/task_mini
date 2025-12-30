import java.util.ArrayList;
import java.util.Calendar;


public class Main {

    public static void main(String[] args) {

        ArrayList<ContentItem> items = new ArrayList<ContentItem>();

        items.add(new VideoLecture("Minecraft gameplay", 2025, 40, "HD"));
        items.add(new VideoLecture("Java basics", 2021, 100, "4K"));

        items.add(new PodcastEpisode("Ted Talk", 2024, 50, "Ted"));
        items.add(new PodcastEpisode("Startup Stories", 2021, 60, "Daniyar"));

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        for (ContentItem item : items) {
            System.out.println(item + " | licenseCost=" + item.getLicenseCost(currentYear));

            if (item instanceof Downloadable) {
                Downloadable downloadable = (Downloadable) item;
                downloadable.download();
                System.out.println("Max downloads per day: " + downloadable.getMaxDownloadsPerDay());
            }

            System.out.println("-----");
        }
    }
}