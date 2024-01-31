package lesson_15.task;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CharCount {
    public static void main(String[] args) {
        System.out.println(new TreeMap<>(calculateGroupBy(TEXT_R)));
    }
    private final static String TEXT_E = "lorem ipsum dolor sit amet consectetur adipiscing elit vitae accumsan cursus ligula lacinia semper parturient iaculis dictum sapien scelerisque hac penatibus fringilla purus placerat magna condimentum lobortis eget feugiat nostra maecenas finibus leo faucibus sem commodo tempus cras rutrum hendrerit montes convallis libero ut aliquet arcu ac posuere sociosqu varius massa aliquam vivamus malesuada lectus consequat at viverra eleifend primis pretium tellus potenti dis ridiculus euismod himenaeos senectus urna suspendisse egestas ante sodales blandit diam curae eros volutpat dignissim justo molestie suscipit etiam phasellus quis tortor felis luctus laoreet habitant mi gravida mollis id vulputate mattis a neque fames";
    private final static String TEXT_R = "Следует отметить, что существующая теория позволяет выполнить важные задания по разработке соответствующих условий активизации. Сделанные на базе интернет-аналитики выводы в равной степени предоставлены сами себе. Принимая во внимание показатели успешности, базовый вектор развития предопределяет высокую востребованность позиций, занимаемых участниками в отношении поставленных задач. Господа, современная методология разработки обеспечивает актуальность поставленных обществом задач. И нет сомнений, что явные признаки победы институционализации, инициированные исключительно синтетически, подвергнуты целой серии независимых исследований. Высокий уровень вовлечения представителей целевой аудитории является четким доказательством простого факта: существующая теория способствует повышению качества приоритизации разума над эмоциями. Повседневная практика показывает, что сложившаяся структура организации создаёт необходимость включения в производственный план целого ряда внеочередных мероприятий с учётом комплекса модели развития. В целом, конечно, постоянное информационно-пропагандистское обеспечение нашей деятельности является качественно новой ступенью укрепления моральных ценностей. В частности, экономическая повестка сегодняшнего дня выявляет срочную потребность первоочередных требований. Таким образом, существующая теория в значительной степени обусловливает важность вывода текущих активов. Непосредственные участники технического прогресса могут быть подвергнуты целой серии независимых исследований. Сложившаяся структура организации играет важную роль в формировании стандартных подходов. Прежде всего, семантический разбор внешних противодействий играет определяющее значение для новых принципов формирования материально-технической и кадровой базы. Лишь предприниматели в сети интернет призывают нас к новым свершениям, которые, в свою очередь, должны быть ассоциативно распределены по отраслям. Безусловно, реализация намеченных плановых заданий требует определения и уточнения дальнейших направлений развития.";

    private static Map<String, Integer> calculateGroupBy(String text) {
        return Arrays.stream(
                text.replaceAll("\\p{P}", "") //punctuation
                        .replaceAll(" ", "")
                        .toLowerCase()
                        .split(""))
                        .collect(Collectors.groupingBy(e -> e))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getValue().get(0), e -> e.getValue().size()));

    }
}
