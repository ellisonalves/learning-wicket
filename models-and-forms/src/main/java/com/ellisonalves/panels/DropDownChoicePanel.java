package com.ellisonalves.panels;

import com.ellisonalves.pojo.Car;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import java.util.Arrays;

public class DropDownChoicePanel extends Panel {

    public DropDownChoicePanel(String id) {
        super(id);
        add(initDropDownChoiceForm());
    }

    private Form<?> initDropDownChoiceForm() {
        DropDownChoice<String> fruits = new DropDownChoice<>(
                "fruits",
                new Model<String>(),
                Arrays.asList("apple", "strawberry", "watermelon")
        );
        fruits.setNullValid(true);

        DropDownChoice<Car> cars = new DropDownChoice<>(
                "cars",
                new Model<Car>(),
                Car.getCarList(),
                new ChoiceRenderer<>("name", "id")
        );

        Form<?> form = new Form<Object>("choiceForm") {
            @Override
            protected void onSubmit() {
                super.onSubmit();
            }
        };

        form.add(fruits);
        form.add(cars);

        return form;
    }

}
