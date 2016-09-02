package com.ellisonalves.pages;

import com.ellisonalves.panels.ModelChainingPanel;
import com.ellisonalves.pojo.Person;
import org.apache.wicket.model.Model;

/**
 * Created by enas on 01/09/2016.
 */
public class ModelChainingPage extends HomePage {

    public ModelChainingPage() {
        add(new ModelChainingPanel("modelChaining", Model.of(new Person())));
    }

}
