package com.mycompany;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class MainTemplate extends WebPage {

	static final String CONTENT_COMPONENT = "contentComponent";

	private static final long serialVersionUID = 1L;

	private Component headerPanel;
	private Component menuPanel;
	private Component footerPanel;

	public MainTemplate() {
		add(headerPanel = new HeaderPanel("headerPanel"));
		add(menuPanel = new MenuPanel("menuPanel"));
		add(footerPanel = new FooterPanel("footerPanel"));
		add(new Label(CONTENT_COMPONENT, "Put your content here"));

		Label simpleLabel = new Label("simpleLabel", "Value of the #simpleLabel");
		simpleLabel.add(AttributeModifier.replace("style", "color:red;font-weight:bold"));
		simpleLabel.add(AttributeModifier.append("style", "color:red;font-weight:bold"));
		simpleLabel.add(AttributeModifier.prepend("style", "color:red;font-weight:bold"));
		add(simpleLabel);
		
		// Page initialization code
		WebMarkupContainer informationBox = new WebMarkupContainer("informationBox");
		informationBox.add(new Label("messagesNumber", 10));
		add(informationBox);
	}

	public Component getHeaderPanel() {
		return headerPanel;
	}

	public Component getMenuPanel() {
		return menuPanel;
	}

	public Component getFooterPanel() {
		return footerPanel;
	}
	
	// Life cycle methods
	// INITIALIZATION STAGE
	@Override
	protected void onInitialize() {
		super.onInitialize();
		/*
		 * - Performed at the beginning of the component lifecycle
		 * - Can safely access use getParent() or getPage()
		 * - It is a special constructor where we can execute a custom initialization of our component. (It can be a page or a component - page = component)
		 * - Need to call super.onInitialize(), usually as first instruction
		 * - Throw IllegalStateException if the super.onInitialize() not be called.
		 * 
		 * */
	}
	
	// RENDERING STAGE
	@Override
	protected void onConfigure() {
		super.onConfigure();
		/*
		 * - It is a good point to manage the component states such as its visibility or enabled state
		 * - Called before the render phase starts
		 * - Use this method to change component's state instead of override isVisible or isEnabled
		 */
	}
	
	@Override
	protected void onBeforeRender() {
		/*
		 * - Don't use this method to change component's state because it won't be invoked if component's visibility is set to false.
		 * - Called before component starts its rendering phase
		 * - Last chance to change its children hierarchy 
		 * - Right place to add and remove children components
		 * - super.onBeforeRender() must be called at the end of the method body to affect our customization. 
		 * - Throw IllegalStateException if the super.onBeforeRender() not be called.
		 */
		super.onBeforeRender();
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
		/*
		 * - It is called to process component tag
		 * - We can manipulate the component through tag argument (Adding/Removing attributes with put, remove, setName)
		 * - As onInitialize need to be called as the first instruction
		 * - To reuse, consider use "behavior" in place of this hook(callback) method.
		 */
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		super.onComponentTagBody(markupStream, openTag);
		/*
		 * - It's used to render a custom body under specific conditions. So, if we want to change the tag body, we should use this hook method.
		 * - Only call super.oncomponentTagBody when we want to preserve the standard rendering mechanism.
		 * - 
		 */
	}
	
	@Override
	protected void onRemove() {
		/*
		 * - Should call the super.onRemove() on the last line of this overrinding.
		 * - Since a component has been removed, we are free to to add it again to the same container or a different one.
		 * - onReAdd is called every time a component has been removed.
		 */
		

		super.onRemove();		
	}

}
