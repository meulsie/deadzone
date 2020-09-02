package net.runelite.client.plugins.DeadZoneAgility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;

public final class DZAgilityOverlay extends Overlay
{
	private final DZAgilityPlugin plugin;
	private final DZAgilityConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private DZAgilityOverlay(final DZAgilityPlugin plugin, final DZAgilityConfig config)
	{
		super(plugin);
		this.plugin = plugin;
		this.config = config;
		this.setPosition(OverlayPosition.BOTTOM_LEFT);
		this.setLayer(OverlayLayer.ABOVE_SCENE);
	}

	public final Dimension render(final Graphics2D graphics)
	{
		this.panelComponent.getChildren().clear();

		if (this.config.displayInfo())
		{
			final TitleComponent title = TitleComponent.builder().text("Agility Helper").color(Color.GREEN).build();
			this.panelComponent.getChildren().add(title);

			final TableComponent tableComponent = new TableComponent();
			tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);
			tableComponent.setGutter(new Dimension(5, 3));

			final String[] strArr = new String[]{"Active:", null};

			final boolean var10004 = this.plugin.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178();

			strArr[1] = ColorUtil.prependColorTag(String.valueOf(var10004), this.plugin.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178() ? Color.GREEN : Color.RED);

			tableComponent.addRow(strArr);
			tableComponent.addRow("Time left:", this.plugin.AB1CaddDEdaHI12361JKLM8NO3ka5gw() + " mins");
			tableComponent.addRow("Course:", this.config.agilityMethod().getName());
			tableComponent.addRow("Step:", String.valueOf(this.plugin.dzAgilityCourseManager.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2() + 1));
			this.panelComponent.getChildren().add(tableComponent);
			this.panelComponent.setPreferredSize(new Dimension(150, this.panelComponent.getBounds().height));
		}

		return this.panelComponent.render(graphics);
	}
}
