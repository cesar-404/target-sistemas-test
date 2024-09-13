import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class ExercicioIII {
    public static void main(String[] args) {
        try {

            File file = new File("src/dados.xml");
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            document.getDocumentElement().normalize();

            NodeList rowList = document.getElementsByTagName("row");
            List<Double> values = IntStream.range(0, rowList.getLength())
                    .mapToObj(rowList::item)
                    .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                    .map(node -> (Element) node)
                    .map(element -> element.getElementsByTagName("valor"))
                    .filter(nl -> nl.getLength() > 0)
                    .map(nl -> nl.item(0).getTextContent())
                    .map(text -> {
                        try {
                            return OptionalDouble.of(Double.parseDouble(text));
                        } catch (NumberFormatException e) {
                            return OptionalDouble.empty();
                        }
                    })
                    .filter(OptionalDouble::isPresent)
                    .map(OptionalDouble::getAsDouble)
                    .filter(value -> value > 0)
                    .toList();

            OptionalDouble minOptional = values.stream().mapToDouble(v -> v).min();
            OptionalDouble maxOptional = values.stream().mapToDouble(v -> v).max();
            double totalRevenue = values.stream().mapToDouble(Double::doubleValue).sum();
            double average = !values.isEmpty() ? totalRevenue / values.size() : 0;

            long daysAboveAverage = values.stream().filter(v -> v > average).count();

            System.out.println("Menor valor: " + minOptional.orElse(0));
            System.out.println("Maior valor: " + maxOptional.orElse(0));
            System.out.println("Número de dias com faturamento superior à média: " + daysAboveAverage);

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}