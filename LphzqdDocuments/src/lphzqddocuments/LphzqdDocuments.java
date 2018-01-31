/*
Lukas Heading
LPHZQD
18131083
9/7/16
 */
package lphzqddocuments;

/**
 *
 * @author lukas
 */
public class LphzqdDocuments {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Document document1 = new Document("Another Life", "Sally Smith");
        
        Document document2 = new Document("Final Word", "Karen Jones", "We should plan for the worst and hope for the best.");
        
        document1.setBody("The grass is always greener on the other side.");
        
        document2.setTitle("Final Words");
        
        System.out.printf("document1:\ntitle: %s\nauthor: %s\nbody: %s\nversion: %d\n\ndocument2:\ntitle: %s\nauthor: %s\nbody: %s\nversion: %d",document1.getTitle(),document1.getAuthor(),document1.getBody(),document1.getVersion(),document2.getTitle(),document2.getAuthor(),document2.getBody(),document2.getVersion());
    }
    
}
