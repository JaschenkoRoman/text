package com.epam.text.composite;

import java.util.List;

public interface Component {
    void add(Component component);
    List<Component> getChildren();
}
