package net.runelite.client.plugins.DeadZoneConstruction;

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

public final class DZConOverlay extends Overlay
{
	private final DZConPlugin plugin;
	private final DZConConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private DZConOverlay(final DZConPlugin plugin, final DZConConfig config)
	{
		super(plugin);
		this.plugin = plugin;
		this.config = config;
		this.setPosition(OverlayPosition.BOTTOM_LEFT);
		this.setLayer(OverlayLayer.ABOVE_SCENE);
	}

	public final Dimension render(final Graphics2D graphics)
	{
		panelComponent.getChildren().clear();

		if (config.displayInfo())
		{
			final TitleComponent title = TitleComponent.builder().text("Construction Helper").color(Color.GREEN).build();
			panelComponent.getChildren().add(title);

			final TableComponent tableComponent = new TableComponent();
			tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);
			tableComponent.setGutter(new Dimension(5, 3));

			final String[] strArr = new String[]{"Active:", null};

			final boolean bool = plugin.isActive();

			strArr[1] = ColorUtil.prependColorTag(String.valueOf(bool), plugin.isActive() ? Color.GREEN : Color.RED);

			tableComponent.addRow(strArr);
			tableComponent.addRow("Method:", config.skillingMethod().getName());
			tableComponent.addRow("Time left:", plugin.getTimeLeft() + " mins");

			panelComponent.getChildren().add(tableComponent);
			panelComponent.setPreferredSize(new Dimension(165, panelComponent.getBounds().height));
		}

		return panelComponent.render(graphics);
	}
}
