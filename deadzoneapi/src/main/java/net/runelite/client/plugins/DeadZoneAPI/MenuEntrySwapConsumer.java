package net.runelite.client.plugins.DeadZoneAPI;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.util.concurrent.ArrayBlockingQueue;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.Point;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.MouseAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class MenuEntrySwapConsumer extends MouseAdapter implements Runnable
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuEntrySwapConsumer.class);

	private final ArrayBlockingQueue<MenuEntry> entriesQueue;
	private final ArrayBlockingQueue<MenuEntrySwapHandler.enum2> entryTypeQueue;

	private final int minDelay;
	private final int maxDelay;
	private final Client client;
	private final ConfigManager configManager;
	private MenuEntry menuEntry;

	@Inject
	MenuEntrySwapConsumer(final ArrayBlockingQueue<MenuEntry> entriesQueue, final ArrayBlockingQueue<MenuEntrySwapHandler.enum2> entryType, final Client client, final ConfigManager configManager)
	{
		this.entriesQueue = entriesQueue;
		this.minDelay = 5;
		this.maxDelay = 10;
		this.entryTypeQueue = entryType;
		this.client = client;
		this.configManager = configManager;
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final MenuOptionClicked menuOptionClicked)
	{
		if (this.menuEntry != null)
		{
			menuOptionClicked.setMenuEntry(this.menuEntry);
			this.menuEntry = null;
		}

	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final MenuEntryAdded event)
	{
		if (this.menuEntry != null)
		{
			this.client.setLeftClickMenuEntry(this.menuEntry);
		}

	}

	public void run()
	{
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
	}

	private void AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		while (true)
		{
			while (true)
			{
				try
				{
					if (!this.entriesQueue.isEmpty() && this.menuEntry == null)
					{
						this.menuEntry = (MenuEntry) this.entriesQueue.poll();
						final int randomDelay;
						if (this.menuEntry.getOpcode() == 1600)
						{
							randomDelay = AB1CaddDEdaHI12361JKLM8NO3ka5gw(this.menuEntry.getParam0(), this.menuEntry.getParam1());
						}
						else
						{
							randomDelay = AB1CaddDEdaHI12361JKLM8NO3ka5gw(this.minDelay, this.maxDelay);
						}

						this.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178();
						Thread.sleep(randomDelay);
					}
					else
					{
						Thread.sleep(5L);
					}
				}
				catch (final Exception var2)
				{
					LOGGER.info("Failed to consume menu entry!");
					var2.printStackTrace();
					return;
				}
			}
		}
	}

	private void DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		if (this.menuEntry != null)
		{
			try
			{
				Point p = this.client.getMouseCanvasPosition();
				final Canvas canvas = this.client.getCanvas();
				final Widget screen = this.client.getViewportWidget();
				if (!this.entryTypeQueue.isEmpty())
				{
					final MenuEntrySwapHandler.enum2 entry = (MenuEntrySwapHandler.enum2) this.entryTypeQueue.poll();

					try
					{
						switch (entry)
						{
							case INVENTORY:
								final Widget inventory = this.client.getWidget(WidgetInfo.INVENTORY);
								p = new Point(AB1CaddDEdaHI12361JKLM8NO3ka5gw(inventory.getCanvasLocation().getX(), inventory.getCanvasLocation().getX() + inventory.getWidth()), AB1CaddDEdaHI12361JKLM8NO3ka5gw(inventory.getCanvasLocation().getY(), inventory.getCanvasLocation().getY() + inventory.getHeight()));
								break;
							case BANK:
								final Widget bank;
								if ((bank = this.client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER)) != null)
								{
									p = new Point(AB1CaddDEdaHI12361JKLM8NO3ka5gw(bank.getCanvasLocation().getX(), bank.getCanvasLocation().getX() + bank.getWidth()), AB1CaddDEdaHI12361JKLM8NO3ka5gw(bank.getCanvasLocation().getY(), bank.getCanvasLocation().getY() + bank.getHeight()));
								}
						}
					}
					catch (final Exception var8)
					{
						LOGGER.info("Failed to get inventory or bank container during consumption!");
						var8.printStackTrace();
						if (p.getX() == -1)
						{
							p = new Point(AB1CaddDEdaHI12361JKLM8NO3ka5gw(1, screen.getWidth()), AB1CaddDEdaHI12361JKLM8NO3ka5gw(1, screen.getHeight()));
						}
					}
				}
				else if (p.getX() == -1)
				{
					p = new Point(AB1CaddDEdaHI12361JKLM8NO3ka5gw(1, screen.getWidth()), AB1CaddDEdaHI12361JKLM8NO3ka5gw(1, screen.getHeight()));
				}

				final long time = System.currentTimeMillis();
				if (!this.client.isStretchedEnabled())
				{
					final MouseEvent mousePressed = new MouseEvent(canvas, 501, time, 0, p.getX(), p.getY(), 1, false, 1);
					final MouseEvent mouseReleased = new MouseEvent(canvas, 502, time, 0, p.getX(), p.getY(), 1, false, 1);
					canvas.dispatchEvent(mouseReleased);
					canvas.dispatchEvent(mousePressed);
					canvas.dispatchEvent(mouseReleased);
					return;
				}

				final double scale = 1.0D + (double) this.configManager.getConfiguration("stretchedmode", "scalingFactor", Integer.TYPE) / 100.0D;
				final MouseEvent mousePressed = new MouseEvent(canvas, 501, time, 0, (int) ((double) p.getX() * scale), (int) ((double) p.getY() * scale), 1, false, 1);
				final MouseEvent mouseReleased = new MouseEvent(canvas, 502, time, 0, (int) ((double) p.getX() * scale), (int) ((double) p.getY() * scale), 1, false, 1);
				canvas.dispatchEvent(mouseReleased);
				canvas.dispatchEvent(mousePressed);
				canvas.dispatchEvent(mouseReleased);
			}
			catch (final Exception var9)
			{
				LOGGER.info("Failed to handle entry actions!");
				var9.printStackTrace();
			}
		}

	}

	private static int AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int min, final int max)
	{
		return (int) (Math.random() * (double) (max - min + 1) + (double) min);
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final MenuEntry menuEntryInProgress)
	{
		this.menuEntry = menuEntryInProgress;
	}
}
