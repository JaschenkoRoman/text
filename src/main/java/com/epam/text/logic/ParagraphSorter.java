package com.epam.text.logic;

import com.epam.text.composite.Component;
import com.epam.text.composite.Composite;
import java.util.Comparator;
import java.util.List;

public class ParagraphSorter implements Sorter {
    private final Comparator<Component>
            COMPARATOR = Comparator.comparing(component -> component.getChildren().size());
    @Override
    public Component sort(Component text) {
        List<Component> paragraphs = text.getChildren();
        paragraphs.sort(COMPARATOR);
        Component sortedText = new Composite();
        paragraphs.forEach(sortedText::add);
        return sortedText;
    }
}
