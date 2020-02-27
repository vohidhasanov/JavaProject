package Func.MyWorks;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class HostingRespository {
    public static List <Hosting> filterHosting (List<Hosting> hosting, Predicate<Hosting> predicate ) {
        return hosting.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}

class Hosting {
    private int Id;
    private String name;
    private String url;

    public Hosting(int id, String name, String url) {
        Id = id;
        this.name = name;
        this.url = url;
    }

    public int getId() {return Id;}
    public String getName() {return name; }
    public String getUrl() { return url;
    }

    @Override
    public String toString() {
        return "Hosting{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}


public class Java8Predicate7 {
    public static void main(String[] args) {
        Hosting h1 = new Hosting(1, "amazon", "aws.amazon.com");
        Hosting h2 = new Hosting (2, "linode", "linode.com");
        Hosting h3 = new Hosting (3, "liquidweb", "liquidweb.com");
        Hosting h4 = new Hosting (4, "google", "google.com");

        List <Hosting> list = Arrays.asList(new Hosting [] {h1, h2, h3, h4});
        List <Hosting> result = HostingRespository.filterHosting(list, x->x.getName().startsWith("g"));
        System.out.println("result is:" + result);

        List <Hosting> result2 = HostingRespository.filterHosting(list, isDeveloperFriendly());
        System.out.println("result2 is: "+ result2);
    }
    
    public static Predicate <Hosting> isDeveloperFriendly () {
        return n->n.getName().equals("linode");
    }
}
