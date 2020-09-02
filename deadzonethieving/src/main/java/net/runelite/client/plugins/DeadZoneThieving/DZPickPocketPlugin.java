package net.runelite.client.plugins.DeadZoneThieving;

import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.queries.BankItemQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.DeadZoneAPI.BankInteractionTypes;
import net.runelite.client.plugins.DeadZoneAPI.DeadZoneAPI;
import net.runelite.client.plugins.DeadZoneAPI.DeadZoneUtilities;
import net.runelite.client.plugins.DeadZoneAPI.MenuEntrySwapHandler;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"unused", "DuplicatedCode"})
@Extension
@PluginDescriptor(
	name = "DZ Thieving Helper",
	description = "Configure DeadZone Thieving Helper",
	tags = {"deadzone", "johnny", "bot", "helper"},
	type = PluginType.SYSTEM,
	enabledByDefault = false
)
@PluginDependency(DeadZoneAPI.class)
public class DZPickPocketPlugin extends Plugin implements KeyListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DZPickPocketPlugin.class);

	@Inject
	private Client client;

	@Inject
	private DeadZoneAPI deadZoneAPI;

	private DeadZoneUtilities deadZoneUtilities;

	@Inject
	private MenuEntrySwapHandler menuEntrySwapHandler;

	@Inject
	private KeyManager keyManager;

	@Inject
	private DZPickPocketConfig config;

	@Inject
	private DZPickPocketOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	private String str = "";

	private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

	private boolean bool1;
	private boolean bool2;

	private int int1;
	private int int2 = -1;

	private Instant instant;

	private int int3 = -1;
	private int int4 = -1;
	private int int5 = -1;
	private int int6 = -1;
	private int int7 = -1;

	private boolean bool3;
	private boolean bool4;

	private int[] foodIDs;
	private int[] dropItemIDs;

	private final List<Integer> itemIDs = new LinkedList<>();

	private final int[] coinPouchIDs = new int[]{22521, 22522, 22523, 25524, 22525, 22526, 22527, 22528, 22529, 22530, 22531, 22532, 22533, 22534, 22535, 22536, 22537, 22538, 24703};

	private boolean JKLM8NO3ka5gM8NO3ka5gwPQRS2;

	private final MenuEntry menuEntry1 = new MenuEntry("", "", 2155, 11, 0, 0, false);
	private final MenuEntry menuEntry2 = new MenuEntry("", "", 13662, 13, 0, 0, false);

	@Provides
	private static DZPickPocketConfig AB1CaddDEdaHI12361JKLM8NO3ka5gw(final ConfigManager configManager)
	{
		return configManager.getConfig(DZPickPocketConfig.class);
	}

	protected void startUp()
	{
		deadZoneUtilities = deadZoneAPI.deadZoneUtilities;
		keyManager.registerKeyListener(this);
		overlayManager.add(overlay);
		scheduledThreadPoolExecutor = deadZoneAPI.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178;
		final String var10001 = ColorUtil.wrapWithColorTag("| ", Color.yellow);
		str = var10001 + ColorUtil.wrapWithColorTag("Thieving Helper", Color.green) + ColorUtil.wrapWithColorTag(" | ", Color.yellow);
	}

	protected void shutDown()
	{
		keyManager.unregisterKeyListener(this);
		overlayManager.remove(overlay);
		cdefghi367869abcdefhJKL1234AB1Cad();
	}

	final boolean AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		return bool2;
	}

	@Subscribe
	private void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() != GameState.LOGGED_IN && AB1CaddDEdaHI12361JKLM8NO3ka5gw())
		{
			cdefghi367869abcdefhJKL1234AB1Cad();
		}

	}

	@Subscribe
	private void onGameTick(final GameTick event)
	{
		if (bool3)
		{
			bool3 = false;
		}
		else
		{
			if (bool2 && client.getLocalPlayer() != null)
			{
				AB35raDWsFGHda212365IJKL12tfa1MNO();
				if (!asgn2kd1p2no455mnop2dqrstuvwxyz111146())
				{
					LOGGER.info("Timeout reached, shutting down!");
					client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str + "Timeout reached, shutting down!", null);
					cdefghi367869abcdefhJKL1234AB1Cad();
					return;
				}

				if (config.dropItems() && deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178() >= config.dropThreshold() && !jkld2369IJgha561gkkbcFdaw1fa5def() && !bool1 && deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(dropItemIDs))
				{
					LOGGER.info("Dropping items!");
					FGw3gHIJdaw1faKLM8NO3ka5gwPQRS23();
					return;
				}

				if (config.autoHeal() && !config.thievingMethod().equals(DZPickPocketMethods.Blackjacking) && deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(foodIDs) && int4 == -1 && !bool1 && !jkld2369IJgha561gkkbcFdaw1fa5def() && client.getBoostedSkillLevel(Skill.HITPOINTS) <= config.hpTheshold())
				{
					LOGGER.info("Healing myself!");
					int3 = 0;
					nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3();
					return;
				}

				if (config.autoWithdraw() && !bool1 && int4 == -1)
				{
					if (!deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(foodIDs) && !config.thievingMethod().equals(DZPickPocketMethods.Blackjacking))
					{
						if (config.dropItems() && deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(dropItemIDs) && !jkld2369IJgha561gkkbcFdaw1fa5def())
						{
							LOGGER.info("Dropping items prior to banking!");
							FGw3gHIJdaw1faKLM8NO3ka5gwPQRS23();
							return;
						}

						if (!jkld2369IJgha561gkkbcFdaw1fa5def() && int6 == -1)
						{
							LOGGER.info("Finding nearest bank...");
							int6 = 0;
							PQRS23TgasdUVWX114666ce13Abefgh93f9awdf();
							bool4 = false;
							return;
						}

						if (jkld2369IJgha561gkkbcFdaw1fa5def())
						{
							LOGGER.info("Withdrawing items...");
							s6641asgn2kd1dasgha1333();
							bool4 = false;
						}

						return;
					}

					if (deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(foodIDs) && jkld2369IJgha561gkkbcFdaw1fa5def())
					{
						deadZoneUtilities.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2();
					}
				}
				else if (jkld2369IJgha561gkkbcFdaw1fa5def() && !config.autoWithdraw() && !bool1)
				{
					deadZoneUtilities.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2();
					return;
				}

				if (config.autoHeal() && !deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(foodIDs) && (!config.autoWithdraw() || config.thievingMethod() == DZPickPocketMethods.Blackjacking))
				{
					LOGGER.info("Couldn't find any available food within inventory, shutting down!");
					client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str + "Couldn't find any available food within inventory, shutting down!", null);
					cdefghi367869abcdefhJKL1234AB1Cad();
					return;
				}

				if (config.dodgyNecklace() && !deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(21143) && deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(new int[]{21143}) && !jkld2369IJgha561gkkbcFdaw1fa5def())
				{
					LOGGER.info("Equipping new dodgy necklace");
					vwxyzQdw3RSTUVwxyz11114XYZ1234();
					return;
				}

				if (deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(coinPouchIDs) && config.emptyCoinPouch() && !bool1)
				{
					final List<Item> coinPouch = deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(coinPouchIDs);

					if (coinPouch.get(0).getQuantity() >= 28)
					{
						LOGGER.info("Emptying coin pouch...");

						bool1 = true;

						scheduledThreadPoolExecutor.schedule(() -> {
							deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(coinPouch.get(0).getId(), 33, 9764864);

							try
							{
								Thread.sleep(500L);
							}
							catch (final Exception var2)
							{
								LOGGER.info(String.valueOf(var2));
							}

							bool1 = false;
						}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);

						return;
					}
				}

				if (int2 == -1)
				{
					final int random;
					if (config.thievingMethod() != DZPickPocketMethods.Blackjacking)
					{
						if (!bool1 && int4 == -1 && int6 == -1 && int3 == -1)
						{
							random = DeadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(1, 100);
							if (random <= 5)
							{
								if (config.skillBreaks() && random <= 2)
								{
									LOGGER.info("Skilling Break Activated");
									client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str + "Taking a break...", null);
									int2 = 0;
									return;
								}

								LOGGER.info("Skipping Step");
								return;
							}

							VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3();
						}
					}
					else
					{
						if (!bool1 && client.getVarbitValue(327) == 0 && int7 == -1 && int3 == -1)
						{
							random = DeadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(1, 100);
							if (random <= 7)
							{
								if (config.skillBreaks() && random <= 2)
								{
									LOGGER.info("Skilling Break Activated");
									client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str + "Taking a break...", null);
									int2 = 0;
									return;
								}

								LOGGER.info("Skipping Step");
								return;
							}

							LOGGER.info("Blackjacking!");
							IOPQRSTUV4abcdefgJKLM8NO3ka5gM8();
							return;
						}

						if (!bool1 && client.getVarbitValue(327) == 1 && int7 == -1)
						{
							VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3();
						}
					}
				}
			}

		}
	}

	@Subscribe
	private void onHitsplatApplied(final HitsplatApplied event)
	{
		if (bool2 && event.getActor() == client.getLocalPlayer())
		{
			LOGGER.info("Detected failed pickpocket!");
			int4 = 0;
			if (config.thievingMethod() == DZPickPocketMethods.Blackjacking)
			{
				final NPC npc = deadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(config.thievingMethod().getNpcIDs());
				if (npc != null)
				{
					bool1 = true;
					scheduledThreadPoolExecutor.schedule(() -> {
						final MenuEntry entry = menuEntry1;
						entry.setIdentifier(npc.getIndex());
						menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);

						try
						{
							Thread.sleep(DeadZoneUtilities.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(250, 500));
						}
						catch (final Exception var3)
						{
							LOGGER.info(String.valueOf(var3));
						}

						bool1 = false;
					}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw() + 100L, TimeUnit.MILLISECONDS);
				}
			}

			int3 = 0;
		}

	}

	@Subscribe
	private void onItemContainerChanged(final ItemContainerChanged event)
	{
		if (event.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY) && bool2)
		{
			if (config.gemBag() && !JKLM8NO3ka5gM8NO3ka5gwPQRS2 && deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178() >= 28)
			{
				stuvwxdwyz1111EFda123ghaswGHIOP();
				return;
			}

			if (config.disableWhenFull() && !config.autoWithdraw() && deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178() >= 28)
			{
				cdefghi367869abcdefhJKL1234AB1Cad();
			}
		}

	}

	@Subscribe
	private void onChatMessage(final ChatMessage message)
	{
		if (bool2 && config.gemBag())
		{
			if (message.getMessage().equals("Your bag is too full to hold all your gems"))
			{
				JKLM8NO3ka5gM8NO3ka5gwPQRS2 = true;
			}
		}
		else if (bool2 && message.getMessage().equals("I can't reach that!"))
		{
			bool3 = true;
		}

	}

	private void JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2()
	{
		instant = Instant.now();
	}

	private boolean jkld2369IJgha561gkkbcFdaw1fa5def()
	{
		final Widget info = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER);
		if (info != null)
		{
			return !info.isHidden() && !info.isSelfHidden();
		}
		else
		{
			return false;
		}
	}

	private void PQRS23TgasdUVWX114666ce13Abefgh93f9awdf()
	{
		bool1 = false;
		scheduledThreadPoolExecutor.schedule(() -> {
			deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(5000, true);
			bool1 = false;
		}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
	}

	private boolean asgn2kd1p2no455mnop2dqrstuvwxyz111146()
	{
		if (instant != null)
		{
			final Duration timeout = Duration.ofMinutes(config.timeout());
			final Duration var2 = Duration.between(instant, Instant.now());
			return var2.compareTo(timeout) < 0;
		}
		else
		{
			return false;
		}
	}

	final long DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		if (instant != null)
		{
			final Duration between = Duration.between(instant, Instant.now());
			return (long) config.timeout() - between.toMinutes();
		}
		else
		{
			return config.timeout();
		}
	}

	private void jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq()
	{
		if (scheduledThreadPoolExecutor != null)
		{
			int1 = 0;
			if (config.autoHeal())
			{
				try
				{
					foodIDs = DeadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(config.foodID());
				}
				catch (final Exception var5)
				{
					LOGGER.info("Failed to parse FoodID, stopping pickpocketing!");
					client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str + "Failed to parse FoodID, shutting down!", null);
					return;
				}
			}

			if (config.dropItems())
			{
				try
				{
					dropItemIDs = DeadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(config.itemsToDrop());
					if (config.itemsToDrop().isEmpty() || config.itemsToDrop().isBlank())
					{
						LOGGER.info("Drop Items enabled without any items specified to drop, stopping thieving!");
						client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str + "Drop Items enabled without any items specified to drop, shutting down!", null);
						return;
					}

					final int[] var1 = DeadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(config.itemsToDrop());

					for (final int i : var1)
					{
						itemIDs.add(i);
					}
				}
				catch (final Exception var6)
				{
					LOGGER.info("Failed to parse Drop Items, stopping thieving!");
					client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str + "Failed to parse Drop Items, shutting down!", null);
					return;
				}
			}

			JKLM8NO3ka5gM8NO3ka5gwPQRS2 = false;
			int4 = -1;
			int3 = -1;
			int6 = -1;
			int7 = -1;
			JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2();
			bool4 = false;
			bool2 = true;
		}

	}

	private void cdefghi367869abcdefhJKL1234AB1Cad()
	{
		bool2 = false;
		instant = null;
		itemIDs.clear();
	}

	private void vwxyzQdw3RSTUVwxyz11114XYZ1234()
	{
		final int finalItemPosition = deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(21143);
		if (finalItemPosition != -1)
		{
			bool1 = true;
			scheduledThreadPoolExecutor.schedule(() -> {
				final MenuEntry entry = new MenuEntry("", "", 21143, 34, finalItemPosition, 9764864, true);
				menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
				bool1 = false;
			}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
		}

	}

	private void s6641asgn2kd1dasgha1333()
	{
		if (client.getVar(Varbits.CURRENT_BANK_TAB) != 0)
		{
			LOGGER.info("Detected incorrect bank tab, switching tabs");
			bool1 = true;
			scheduledThreadPoolExecutor.schedule(() -> {
				final MenuEntry entry = new MenuEntry("View all items", "", 1, 57, 10, 786442, true);
				menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
				bool1 = false;
			}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
		}
		else
		{
			long delay = deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
			if (config.dodgyNecklace() && !deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(new int[]{21143}) && deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(21143, 1))
			{
				bool1 = true;
				scheduledThreadPoolExecutor.schedule(() -> AB1CaddDEdaHI12361JKLM8NO3ka5gw(21143, BankInteractionTypes.WITHDRAW_FIVE), delay, TimeUnit.MILLISECONDS);
				delay += deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
			}

			final int[] var3 = foodIDs;

			for (final int foodID : var3)
			{
				if (deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(foodID, 1))
				{
					bool1 = true;
					scheduledThreadPoolExecutor.schedule(() -> AB1CaddDEdaHI12361JKLM8NO3ka5gw(foodID, BankInteractionTypes.WITHDRAW_TEN), delay, TimeUnit.MILLISECONDS);
					return;
				}
			}

			LOGGER.info("Couldn't find any available food within bank, shutting down!");
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str + "Couldn't find any available food within bank, shutting down!", null);
			cdefghi367869abcdefhJKL1234AB1Cad();
			bool1 = false;
		}
	}

	private void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int id, final BankInteractionTypes type)
	{
		try
		{
			final List<WidgetItem> items = (new BankItemQuery()).result(client).list;

			assert items != null;

			int itemPosition = 0;
			if (items.size() > 0)
			{
				for (final Iterator<WidgetItem> var8 = items.iterator(); var8.hasNext(); ++itemPosition)
				{
					final WidgetItem item = var8.next();
					if (item != null && item.getId() == id)
					{
						bool1 = true;
						final int finalItemPosition = itemPosition;
						scheduledThreadPoolExecutor.schedule(() -> {
							final MenuEntry entry = type.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
							entry.setParam0(finalItemPosition);
							menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
							bool1 = false;
						}, 0, TimeUnit.MILLISECONDS);
						return;
					}
				}
			}

		}
		catch (final Exception var7)
		{
			LOGGER.info("Failed to withdraw item! ID: " + id);
			var7.printStackTrace();
		}
	}

	private void nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3()
	{
		try
		{
			final ItemContainer container = client.getItemContainer(InventoryID.INVENTORY);
			if (container != null)
			{
				final Item[] items = container.getItems();
				final List<Integer> foodIDList = Ints.asList(foodIDs);
				long delay = deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw();

				for (final Item item : items)
				{
					if (foodIDList.contains(item.getId()))
					{
						bool1 = true;
						scheduledThreadPoolExecutor.schedule(() -> {
							deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(item.getId(), 33, 9764864);
						}, delay, TimeUnit.MILLISECONDS);
						delay += deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
						break;
					}
				}

				scheduledThreadPoolExecutor.schedule(() -> {
					bool1 = false;
				}, delay, TimeUnit.MILLISECONDS);
			}

		}
		catch (final Exception var8)
		{
			LOGGER.info("Failed to heal myself!");
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str + "Failed to heal myself!", null);
			var8.printStackTrace();
		}
	}

	private void stuvwxdwyz1111EFda123ghaswGHIOP()
	{
		bool1 = true;
		scheduledThreadPoolExecutor.schedule(() -> {
			try
			{
				final MenuEntry entry = new MenuEntry("Fill", "Fill", 12020, 33, 0, 9764864, false);
				menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
			}
			catch (final Exception var2)
			{
				LOGGER.info("Failed to fill gem bag!");
				var2.printStackTrace();
			}

			bool1 = false;
		}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
	}

	private void FGw3gHIJdaw1faKLM8NO3ka5gwPQRS23()
	{
		try
		{
			final ItemContainer inventoryContainer = client.getItemContainer(InventoryID.INVENTORY);
			long delay = 0L;
			if (inventoryContainer != null)
			{
				final Item[] items = inventoryContainer.getItems();
				if (items.length > 0)
				{
					int itemPosition = 0;

					for (final Item item : items)
					{
						if (itemIDs.contains(item.getId()))
						{
							delay += deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
							AB1CaddDEdaHI12361JKLM8NO3ka5gw(item.getId(), itemPosition, delay);
						}

						++itemPosition;
					}
				}
			}

			bool1 = true;
			scheduledThreadPoolExecutor.schedule(() -> {
				bool1 = false;
			}, delay, TimeUnit.MILLISECONDS);
		}
		catch (final Exception var8)
		{
			LOGGER.info("Failed to drop inventory items!");
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str + "Failed to drop inventory items!", null);
			var8.printStackTrace();
		}
	}

	private void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int itemID, final int itemPosition, final long delay)
	{
		bool1 = true;
		scheduledThreadPoolExecutor.schedule(() -> {
			final MenuEntry entry = new MenuEntry("", "", itemID, 37, itemPosition, 9764864, true);
			menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
		}, delay, TimeUnit.MILLISECONDS);
	}

	private void IOPQRSTUV4abcdefgJKLM8NO3ka5gM8()
	{
		if (config.autoHeal() && deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(foodIDs) && int3 == -1 && !bool1 && !jkld2369IJgha561gkkbcFdaw1fa5def() && client.getBoostedSkillLevel(Skill.HITPOINTS) <= config.hpTheshold())
		{
			LOGGER.info("Healing myself!");
			int3 = 0;
			nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3();
		}
		else
		{
			NPC npc = null;
			if (int1 != 0)
			{
				npc = deadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(int1);
			}

			if (npc == null)
			{
				npc = deadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(config.thievingMethod().getNpcIDs());
			}

			if (npc != null)
			{
				final Player player = client.getLocalPlayer();

				if (player == null)
				{
					return;
				}

				if (bool4 && npc.getLocalLocation().distanceTo(player.getLocalLocation()) > config.distanceCheck() * 124)
				{
					LOGGER.info("NPC out of distance!");
					if (int1 != 0)
					{
						int1 = 0;
						return;
					}

					client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str + "Could not find relevent NPC within range, shutting down!", null);
					cdefghi367869abcdefhJKL1234AB1Cad();
					return;
				}

				if (!bool4 && npc.getLocalLocation().distanceTo(player.getLocalLocation()) < config.distanceCheck() * 124)
				{
					bool4 = true;
				}

				int1 = npc.getId();
				bool1 = true;
				final NPC finalNpc = npc;
				scheduledThreadPoolExecutor.schedule(() -> {
					try
					{
						final MenuEntry entry = menuEntry2;
						entry.setIdentifier(finalNpc.getIndex());
						menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
					}
					catch (final Exception var3)
					{
						LOGGER.info("Failed to knockout guard!");
						var3.printStackTrace();
					}

					bool1 = false;
				}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
			}

		}
	}

	private void VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3()
	{
		switch (config.thievingMethod())
		{
			case Ardy_Knights:
			case Farmers:
			case Master_Farmers:
			case Blackjacking:
			case Tzhaar:
			case Elves:
			case Vyrewatch:
				NPC npc = null;

				if (int1 != 0)
				{
					npc = deadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(int1);
				}

				if (npc == null)
				{
					npc = deadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(config.thievingMethod().getNpcIDs());
				}

				if (npc != null)
				{
					final Player player = client.getLocalPlayer();

					if (player == null)
					{
						return;
					}

					if (bool4 && npc.getLocalLocation().distanceTo(player.getLocalLocation()) > config.distanceCheck() * 124)
					{
						LOGGER.info("NPC out of distance!");
						if (int1 != 0)
						{
							int1 = 0;
							return;
						}

						client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", str + "Could not find relevent NPC within range, shutting down!", null);
						cdefghi367869abcdefhJKL1234AB1Cad();
						return;
					}

					if (!bool4 && npc.getLocalLocation().distanceTo(player.getLocalLocation()) < config.distanceCheck() * 124)
					{
						bool4 = true;
					}

					LOGGER.info("Pickpocketing!");
					int1 = npc.getId();
					bool1 = true;
					final NPC finalNpc = npc;
					scheduledThreadPoolExecutor.schedule(() -> {
						try
						{
							final MenuEntry entry = menuEntry1;
							entry.setIdentifier(finalNpc.getIndex());
							menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
						}
						catch (final Exception var3)
						{
							LOGGER.info("Failed to pickpocket!");
							var3.printStackTrace();
						}

						bool1 = false;
					}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
					return;
				}
				break;
			case Stalls:
				final GameObject object = deadZoneUtilities.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(config.thievingMethod().getNpcIDs());
				if (object != null && client.getLocalPlayer() != null && int5 == -1 && object.getLocalLocation().distanceTo(client.getLocalPlayer().getLocalLocation()) <= 300)
				{
					LOGGER.info("Stealing!");
					int5 = 0;
					bool1 = true;
					scheduledThreadPoolExecutor.schedule(() -> {
						try
						{
							deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(4, new int[]{object.getId()});
						}
						catch (final Exception var2)
						{
							LOGGER.info("Failed to steal!");
							var2.printStackTrace();
						}

						bool1 = false;
					}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
				}
		}

	}

	private void AB35raDWsFGHda212365IJKL12tfa1MNO()
	{
		int random;
		if (int2 >= 0)
		{
			random = DeadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(8, 22);
			if (int2 + 1 >= random)
			{
				int2 = -1;
			}
			else
			{
				++int2;
			}
		}

		if (int4 >= 0)
		{
			random = DeadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(5, 7);
			if (int4 + 1 >= random)
			{
				int4 = -1;
			}
			else
			{
				++int4;
			}
		}

		if (int5 >= 0)
		{
			random = DeadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(2, 3);
			if (int5 + 1 >= random)
			{
				int5 = -1;
			}
			else
			{
				++int5;
			}
		}

		if (int7 >= 0)
		{
			if (int7 + 1 >= 2)
			{
				int7 = -1;
			}
			else
			{
				++int7;
			}
		}

		if (int6 >= 0)
		{
			random = DeadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(6, 8);
			if (int6 + 1 >= random)
			{
				int6 = -1;
			}
			else
			{
				++int6;
			}
		}

		if (int3 >= 0)
		{
			random = DeadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(2, 3);
			if (int3 + 1 >= random)
			{
				int3 = -1;
				return;
			}

			++int3;
		}

	}

	@Override
	public void keyTyped(final KeyEvent keyEvent)
	{
	}

	@Override
	public void keyPressed(final KeyEvent keyEvent)
	{
		if (client.getGameState() == GameState.LOGGED_IN && config.toggleKey().matches(keyEvent) && client.getCanvas().hasFocus())
		{
			if (!AB1CaddDEdaHI12361JKLM8NO3ka5gw())
			{
				jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq();
				return;
			}

			cdefghi367869abcdefhJKL1234AB1Cad();
		}
	}

	@Override
	public void keyReleased(final KeyEvent keyEvent)
	{
	}
}
