package JavaConcepts.GenericCollections.FlatMapExample;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Article{
   private List<Article> articles;
   private final String title;
   private final String author;
    private List<String> tags;


//static
//    {
//        articles= ArticleRunner.articles;
//    }



    public Article(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }



    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<String> getTags() {
        return tags;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Article{" + "title='"
                + title + '\''
                +  ", author='" + author + '\'' +
                ", tags=" + tags +
                '}';
    }

    public Optional <Article> getFirstJavaArticle () {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java")).findFirst();
    }

    public Map<String , List <Article>> groupByAuthors () {
        return articles.stream()
                .collect(Collectors.groupingBy(Article::getAuthor));
    }

    public Set<String> getDistincTags () {
        return articles.stream()
                .flatMap(article -> article.getTags().stream())
                .collect(Collectors.toSet());
    }


}

class ArticleRunner {
 public List<Article> articles;

//    public ArticleRunner(String title, String author, List<String> tags) {
//        super(title, author, tags);
//    }

//static
//    {
//         articles = articles.;
//    }


    //    public Optional <Article> getFirstJavaArticle () {
//        return articles.stream()
//                .filter(article -> article.getTags().contains("Java")).findFirst();
//    }
//
//
//    public Map <String, List<Article>> groupByAuthor () {
//            return articles.stream()
//                    .collect(Collectors.groupingBy(Article::getAuthor));  // or article->article.getAuthor()
//    }
//
//    public Set<String> getDistinctTags() {
//        return articles.stream()
//                .flatMap(article -> article.getTags().stream())
//                .collect(Collectors.toSet());
//    }

public static List<Article> getArticlesList (List <Article> articles) {

    return articles;
}


    public static void main(String[] args) {
        Article article1 =new Article("Java in Depth", "Key Horstmann", asList("Java", "Coding", "Tutorial"));
        Article article2 = new Article("Java for Dummies", "Gerbert Shield", asList("Java", "beginners", "Series"));
        Article article3= new Article("Cake making", "Jim Brown", asList("Baking", "Cookig", "Food"));
        Article article4 = new Article ("Body Training", "Max Stern", asList("Sport", "Bodybuilding", "Fitness"));


        List <Article> articles = asList(article1, article2, article3, article4);
        Article articleList=article1;
        articleList.setArticles(articles);
        System.out.println(articleList.getFirstJavaArticle());
        System.out.println(articleList.groupByAuthors());
        System.out.println(articleList.getDistincTags());

        //new ArticleRunner().articles=articles;



        //System.out.println(article1.getFirstJavaArticle());


//        List <Article> articles = asList(new Article ("Java in Depth", "Key Horstmann", asList("Java", "Coding", "Tutorial")),
//                new Article ("Java for Dummies", "Gerbert Shield", asList("Java", "beginners", "Series")),
//                new Article("Cake making", "Jim Brown", asList("Baking", "Cookig", "Food")),
//                new Article("Body Training", "Max Stern", asList("Sport", "Bodybuilding", "Fitness"))));




//        Optional<Article> getFirstJavaArticle = articles.stream()
//                .filter(article -> article.getTags().contains("Java")).findFirst();
//
//
//        List <Article> getAllJavaArticles = articles.stream()
//                .filter(article -> article.getTags().contains("Java"))
//                .collect(Collectors.toList());

//        System.out.println(new ArticleRunner().getFirstJavaArticle());
//        System.out.println(new ArticleRunner().groupByAuthor());
//        System.out.println(new ArticleRunner().getDistinctTags());




//        System.out.println(getFirstJavaArticle);
//        System.out.println(getAllJavaArticles);


    }
}