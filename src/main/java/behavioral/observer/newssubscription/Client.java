package behavioral.observer.newssubscription;

public class Client {
    public static void main(String[] args) {
        NewsService newsService = new NewsService();

        Subscriber subscriber1 = new Subscriber("John");
        Subscriber subscriber2 = new Subscriber("Jane");

        newsService.registerObserver(subscriber1);
        newsService.registerObserver(subscriber2);

        newsService.setNews("Breaking news: The sky is blue!");

        newsService.removeObserver(subscriber1);

        newsService.setNews("Breaking news: The grass is green!");
    }
}
