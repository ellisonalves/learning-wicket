package com.mycompany;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

public class SwappingLabels extends WebPage {

	private static final long serialVersionUID = 1L;

	private Label firstLabel;
	private Label secondLabel;	
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		firstLabel = new Label("label", "First Label");
		secondLabel = new Label("label", "Second Label");
		
		add(firstLabel);
		add(new Link<Object>("reload") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				if (getPage().contains(firstLabel, true))
					getPage().replace(secondLabel);
				else
					getPage().replace(firstLabel);				
			}
		});
		
		// onComponentTag example
		add(new Label("helloMessage", "It was a H1 and now is a span") {

			private static final long serialVersionUID = 1L;
			
			@Override
			protected void onComponentTag(ComponentTag tag) {
				super.onComponentTag(tag);

				tag.setName("span");
				tag.put("style", "font-weight:bold;");
			}
		});
		
		// onComponentTagBody example
		add(new Label("helloMessageComponentTagBody", "Hello World Component Tag body") {

			private static final long serialVersionUID = 1L;
			
			@Override
			public boolean isEnabled() {
				return false;
			}
			
			@Override
			public void onComponentTagBody(MarkupStream markupStream,
					ComponentTag openTag) {
				if (!isEnabled())
					replaceComponentTagBody(markupStream, openTag, "( the component is disabled)");
				else
					super.onComponentTagBody(markupStream, openTag);
			}
			
		});
	}
	
	@Override
	protected void onBeforeRender() {
		if (contains(firstLabel, true))
			replace(secondLabel);
		else
			replace(firstLabel);

		// - Must be invoked at the end of this method
		super.onBeforeRender();
	}

}
