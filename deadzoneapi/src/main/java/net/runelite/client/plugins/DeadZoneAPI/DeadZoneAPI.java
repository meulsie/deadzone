package net.runelite.client.plugins.DeadZoneAPI;

import com.google.inject.Provides;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.util.Text;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.util.ColorUtil;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"DuplicatedCode", "unused"})
@Extension
@PluginDescriptor(
	name = "DZ API",
	description = "Configure DeadZone Plugins",
	tags = {"deadzone", "api", "dz"},
	type = PluginType.SYSTEM
)
public class DeadZoneAPI extends Plugin
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DeadZoneAPI.class);

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	public DeadZoneUtilities deadZoneUtilities;

	@Inject
	private MenuEntrySwapHandler menuEntrySwapHandler;

	@Inject
	private DeadZoneConfig config;

	public ScheduledThreadPoolExecutor DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178;

	public String JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2 = "";

	@Provides
	private static DeadZoneConfig getConfig(final ConfigManager configManager)
	{
		return configManager.getConfig(DeadZoneConfig.class);
	}

	protected void startUp()
	{
		this.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178 = new ScheduledThreadPoolExecutor(10, new DiscardPolicy());
		final String var10001 = ColorUtil.wrapWithColorTag("| ", Color.yellow);
		this.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2 = var10001 + ColorUtil.wrapWithColorTag("DeadZone", Color.green) + ColorUtil.wrapWithColorTag(" | ", Color.yellow);
	}

	protected void shutDown()
	{
		this.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178.shutdown();
	}

	@Subscribe
	private void onCommandExecuted(final CommandExecuted event)
	{
		if (event.getCommand().equalsIgnoreCase("dz") && event.getArguments().length > 0)
		{
			final String event1 = event.getArguments()[0];
			byte var2 = -1;
			switch (event1.hashCode())
			{
				case -2020599460:
					if (event1.equals("inventory"))
					{
						var2 = 0;
					}
					break;
				case -1170887058:
					if (event1.equals("testitems"))
					{
						var2 = 3;
					}
					break;
				case -864993596:
					break;
				case 97532676:
					if (event1.equals("flush"))
					{
						var2 = 4;
					}
					break;
				case 1076356494:
					if (event1.equals("equipment"))
					{
						var2 = 1;
					}
			}

			switch (var2)
			{
				case 0:
					this.vwxyzQdw3RSTUVwxyz11114XYZ1234();
					return;
				case 1:
					this.s6641asgn2kd1dasgha1333();
					return;
				case 3:
					this.nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3();
					return;
				case 4:
					LOGGER.info("Flushing menu queue!");
					this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
			}

		}
	}

	private void vwxyzQdw3RSTUVwxyz11114XYZ1234()
	{
		final ItemContainer container;
		if ((container = this.client.getItemContainer(InventoryID.INVENTORY)) != null)
		{
			final Item[] items = container.getItems();
			final List<Integer> printedItems = new LinkedList<>();

			for (final Item item : items)
			{
				if (!printedItems.contains(item.getId()) && item.getId() != -1)
				{
					printedItems.add(item.getId());
					final String itemName = Text.standardize(this.itemManager.getItemDefinition(item.getId()).getName());
					this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", this.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2 + "Item: " + itemName + " ID: " + item.getId(), null);
				}
			}
		}

	}

	private void s6641asgn2kd1dasgha1333()
	{
		final ItemContainer container;
		if ((container = this.client.getItemContainer(InventoryID.EQUIPMENT)) != null)
		{
			final Item[] items = container.getItems();
			final List<Integer> printedItems = new LinkedList<>();

			for (final Item item : items)
			{
				if (!printedItems.contains(item.getId()) && item.getId() != -1)
				{
					printedItems.add(item.getId());
					final String itemName = Text.standardize(this.itemManager.getItemDefinition(item.getId()).getName());
					this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", this.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2 + "Item: " + itemName + " ID: " + item.getId(), null);
				}
			}
		}
	}

	@Subscribe
	private void onMenuOptionClicked(final MenuOptionClicked event)
	{
		if (this.config.devTools())
		{
			LOGGER.info(createMenuEntryString(event));
		}

		this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw.AB1CaddDEdaHI12361JKLM8NO3ka5gw(event);
	}

	@Subscribe
	private void onMenuEntryAdded(final MenuEntryAdded event)
	{
		this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw.AB1CaddDEdaHI12361JKLM8NO3ka5gw(event);
	}

	@Subscribe
	private void onAnimationChanged(final AnimationChanged event)
	{
		if (this.client.getLocalPlayer() != null)
		{
			final Player local = this.client.getLocalPlayer();
			if (this.config.devTools() && event.getActor() == local)
			{
				LOGGER.info("Anim Change: " + event.getActor().getAnimation());
			}
		}

	}

	@Subscribe
	private void onWidgetLoaded(final WidgetLoaded event)
	{
		if (this.config.devTools())
		{
			LOGGER.info("Menu Opened ID: " + event.getGroupId());
		}

	}

	private static String createMenuEntryString(final MenuEntry e)
	{
		return "new MenuEntry(\"" + e.getOption() + "\", \"" + e.getTarget() + "\", " + e.getIdentifier() + ", " + e.getOpcode() + ", " + e.getParam0() + ", " + e.getParam1() + ", " + e.isForceLeftClick() + ");";
	}

	private void nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3()
	{
		try
		{
			final int[] var1;
			final int var2 = (var1 = DeadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(this.config.testItems())).length;

			for (int var3 = 0; var3 < var2; ++var3)
			{
				final int item = var1[var3];
				this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", this.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2 + "Valid ID: " + item, null);
			}

		}
		catch (final Exception var5)
		{
			this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", this.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2 + "Failed to parse Test Items!", null);
		}
	}
}
