package com.ellisonalves.pages;

import com.ellisonalves.panels.DropDownChoicePanel;

public class DropDownChoicePage extends HomePage {

    public DropDownChoicePage() {
        add(new DropDownChoicePanel("choicePanel"));
    }
}
