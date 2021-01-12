package com.takeaway.pages;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BasePage extends PageObject {

    /**
     * This generic method is used to get the text from a list of elements.
     *
     * @param elements : List of WebElements
     *
     * @return List of String
     *
     *         For example : basePage.getTextOfElements(locator.suggestedAddresses);
     *
     * @since Jan 2021
     * @author hemantbanafal
     */
    public List<String> getTextOfElements(List<WebElementFacade> elements) {
        List<String> texts = new ArrayList<String>();
        for (WebElementFacade element : elements)
            texts.add(element.getText());

        return texts;
    }

}
