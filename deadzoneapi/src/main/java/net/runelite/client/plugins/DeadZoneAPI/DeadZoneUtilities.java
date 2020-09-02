package net.runelite.client.plugins.DeadZoneAPI;

import com.google.inject.Inject;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.annotation.Nullable;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GroundObject;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuOpcode;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.TileObject;
import net.runelite.api.VarClientStr;
import net.runelite.api.Varbits;
import net.runelite.api.WallObject;
import net.runelite.api.queries.BankItemQuery;
import net.runelite.api.queries.DecorativeObjectQuery;
import net.runelite.api.queries.GameObjectQuery;
import net.runelite.api.queries.GroundObjectQuery;
import net.runelite.api.queries.InventoryItemQuery;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.queries.NPCQuery;
import net.runelite.api.queries.WallObjectQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.menus.MenuManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
@Singleton
public class DeadZoneUtilities
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DeadZoneUtilities.class);

	@Inject
	private Client client;
	@Inject
	private final DeadZoneConfig config;
	@Inject
	private MenuManager menuManager;
	@Inject
	private ItemManager itemManager;
	@Inject
	private MenuEntrySwapHandler menuEntrySwapHandler;

	public Random AB1CaddDEdaHI12361JKLM8NO3ka5gw = new Random();
	public boolean DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178;
	public String JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2;

	private static final MenuEntry MENU_ENTRY = new MenuEntry("", "", 1, 57, 11, 786434, true);
	private static final Varbits[] VARBITS_1 = new Varbits[]{Varbits.RUNE_POUCH_AMOUNT1, Varbits.RUNE_POUCH_AMOUNT2, Varbits.RUNE_POUCH_AMOUNT3};
	private static final Varbits[] VARBITS_2 = new Varbits[]{Varbits.RUNE_POUCH_RUNE1, Varbits.RUNE_POUCH_RUNE2, Varbits.RUNE_POUCH_RUNE3};

	@Inject
	private DeadZoneUtilities(final DeadZoneConfig config)
	{
		this.config = config;
	}

	public final long AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		return (long) AB1CaddDEdaHI12361JKLM8NO3ka5gw((double) Math.round(this.AB1CaddDEdaHI12361JKLM8NO3ka5gw.nextGaussian() * (double) this.config.deviation() + (double) this.config.target()), this.config.minDelay(), this.config.maxDelay());
	}

	public final int DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		return Objects.requireNonNull(this.client.getWidget(WidgetInfo.INVENTORY)).getWidgetItems().size();
	}

	public final List<Item> AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int... itemIDs)
	{
		assert this.client.isClientThread();

		return (new InventoryItemQuery(InventoryID.INVENTORY)).idEquals(itemIDs).result(this.client).list;
	}

	private List<WidgetItem> nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3(final int... itemIDs)
	{
		assert this.client.isClientThread();

		return (new InventoryWidgetItemQuery()).idEquals(itemIDs).result(this.client).list;
	}

	public final boolean DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(final int[] itemIDs)
	{
		assert this.client.isClientThread();

		return (new InventoryItemQuery(InventoryID.INVENTORY)).idEquals(itemIDs).result(this.client).first() != null;
	}

	public final boolean AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int itemID, final int quantity)
	{
		assert this.client.isClientThread();

		final Item item;
		if ((item = (new InventoryItemQuery(InventoryID.INVENTORY)).idEquals(new int[]{itemID}).result(this.client).first()) != null)
		{
			return item.getQuantity() >= quantity;
		}
		else
		{
			return false;
		}
	}

	public final boolean AB1CaddDEdaHI12361JKLM8NO3ka5gw(final List<Integer> itemIDs)
	{
		assert this.client.isClientThread();

		final ArrayList<Item> items;

		if ((items = (new InventoryItemQuery(InventoryID.INVENTORY)).result(this.client).list).size() > 0)
		{
			for (final Object o : items)
			{
				final Item item = (Item) o;
				if (!itemIDs.contains(item.getId()) && item.getId() != -1)
				{
					return false;
				}
			}
		}

		return true;
	}

	public final boolean AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int itemID)
	{
		assert this.client.isClientThread();

		return (new InventoryItemQuery(InventoryID.EQUIPMENT)).idEquals(new int[]{itemID}).result(this.client).first() != null;
	}

	private void playerTabTypesMethod()
	{
		if (this.client.isResized())
		{
			if (this.client.getVar(Varbits.SIDE_PANELS) == 0)
			{
				this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(PlayerTabTypes.LOGOUT.AB1CaddDEdaHI12361JKLM8NO3ka5gw());
			}
			else
			{
				this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(PlayerTabTypes.LOGOUT.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178());
			}
		}
		else
		{
			this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(PlayerTabTypes.LOGOUT.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2());
		}
	}

	private void jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq()
	{
		this.playerTabTypesMethod();

		try
		{
			Thread.sleep(PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(30, 50));
		}
		catch (final InterruptedException var2)
		{
			var2.printStackTrace();
		}

		this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(new MenuEntry("Logout", "", 1, 57, -1, 11927560, false));
	}

	public final void JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2()
	{
		this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(MENU_ENTRY, MenuEntrySwapHandler.enum2.BANK);
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(int closestDistance, final boolean prioritizeBank)
	{
		if (closestDistance == 0)
		{
			closestDistance = 30000;
		}

		if (this.client.getLocalPlayer() != null)
		{
			boolean foundBank = false;
			enum1 closestType = enum1.NPC;
			final GameObject boothObject;
			if ((boothObject = this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(BankObjects.BANK_BOOTHS.AB1CaddDEdaHI12361JKLM8NO3ka5gw())) != null && boothObject.getLocalLocation().distanceTo(this.client.getLocalPlayer().getLocalLocation()) < closestDistance)
			{
				foundBank = true;
				closestType = enum1.BoothObject;
				closestDistance = boothObject.getLocalLocation().distanceTo(this.client.getLocalPlayer().getLocalLocation());
				if (prioritizeBank)
				{
					this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(new MenuEntry("", "", boothObject.getId(), 4, boothObject.getSceneMinLocation().getX(), boothObject.getSceneMinLocation().getY(), false));
					return;
				}
			}

			final GameObject chestObject;
			if ((chestObject = this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(BankObjects.BANK_CHESTS.AB1CaddDEdaHI12361JKLM8NO3ka5gw())) != null && chestObject.getLocalLocation().distanceTo(this.client.getLocalPlayer().getLocalLocation()) < closestDistance)
			{
				foundBank = true;
				closestType = enum1.ChestObject;
				closestDistance = chestObject.getLocalLocation().distanceTo(this.client.getLocalPlayer().getLocalLocation());
				if (prioritizeBank)
				{
					this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(new MenuEntry("", "", chestObject.getId(), 3, chestObject.getSceneMinLocation().getX(), chestObject.getSceneMinLocation().getY(), false));
					return;
				}
			}

			final NPC bankNPC;
			if ((bankNPC = this.jkld2369IJgha561gkkbcFdaw1fa5def(BankObjects.BANK_NPCS.AB1CaddDEdaHI12361JKLM8NO3ka5gw())) != null && bankNPC.getLocalLocation().distanceTo(this.client.getLocalPlayer().getLocalLocation()) < closestDistance)
			{
				foundBank = true;
				closestType = enum1.NPC;
				if (prioritizeBank)
				{
					this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(new MenuEntry("", "", bankNPC.getIndex(), 11, 0, 0, false));
					return;
				}
			}

			if (foundBank)
			{
				switch (closestType)
				{
					case NPC:
						this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(new MenuEntry("", "", bankNPC.getIndex(), 11, 0, 0, false));
						return;
					case BoothObject:
						this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(new MenuEntry("", "", boothObject.getId(), 4, boothObject.getSceneMinLocation().getX(), boothObject.getSceneMinLocation().getY(), false));
						return;
					case ChestObject:
						this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(new MenuEntry("", "", chestObject.getId(), 3, chestObject.getSceneMinLocation().getX(), chestObject.getSceneMinLocation().getY(), false));
						break;
				}
			}
		}

	}

	public final boolean DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(final int id, final int quantity)
	{
		final WidgetItem item;
		if ((item = (new BankItemQuery()).idEquals(new int[]{id}).result(this.client).first()) != null)
		{
			return item.getQuantity() >= quantity;
		}
		else
		{
			return false;
		}
	}

	public final void jkld2369IJgha561gkkbcFdaw1fa5def()
	{
		final MenuEntry entry = new MenuEntry("", "", 1, 57, -1, 786473, true);
		this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
	}

	private void cdefghi367869abcdefhJKL1234AB1Cad()
	{
		final MenuEntry entry = new MenuEntry("", "", 1, 57, -1, 786475, true);
		this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int id, final BankInteractionTypes type, final int quantity)
	{
		final Widget inventory;
		if ((inventory = this.client.getWidget(WidgetInfo.INVENTORY)) != null)
		{
			final WidgetItem[] quantity2;
			final int var4 = (quantity2 = inventory.getWidgetItems().toArray(new WidgetItem[0])).length;

			for (int var5 = 0; var5 < var4; ++var5)
			{
				final WidgetItem item;
				if ((item = quantity2[var5]).getId() == id)
				{
					final MenuEntry entry;
					(entry = type.AB1CaddDEdaHI12361JKLM8NO3ka5gw()).setParam0(item.getIndex());
					this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
					return;
				}
			}
		}

	}

	public final List<Item> JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2(final int... itemIds)
	{
		assert this.client.isClientThread();

		try
		{
			final ItemContainer inventoryContainer;
			if ((inventoryContainer = this.client.getItemContainer(InventoryID.EQUIPMENT)) == null)
			{
				return null;
			}
			else
			{
				final Item[] items = inventoryContainer.getItems();
				final List<Item> itemList = new LinkedList<>();

				for (final Item item : items)
				{
					final int var8 = itemIds.length;

					for (final int id : itemIds)
					{
						if (item.getId() == id)
						{
							itemList.add(item);
							break;
						}
					}
				}

				return itemList;
			}
		}
		catch (final Exception var11)
		{
			var11.printStackTrace();
			return null;
		}
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int opCode, final int... ids)
	{
		final GameObject object;
		if ((object = this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(ids)) != null)
		{
			final int param0 = object.getSceneMinLocation().getX();
			final int param1 = object.getSceneMinLocation().getY();
			final MenuEntry entry = new MenuEntry("", "", object.getId(), opCode, param0, param1, true);
			this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
		}

	}

	private void stuvwxdwyz1111EFda123ghaswGHIOP(final int... ids)
	{
		final GameObject object;
		if ((object = this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(ids)) != null)
		{
			final int param0 = object.getSceneMinLocation().getX();
			final int param1 = object.getSceneMinLocation().getY();
			final MenuEntry entry = new MenuEntry("", "", 0, MenuOpcode.WALK.getId(), param0, param1, false);
			this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
		}

	}

	public final boolean AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int itemID, final int opCode, final int actionParam)
	{
		final ItemContainer inventoryContainer;
		if ((inventoryContainer = this.client.getItemContainer(InventoryID.INVENTORY)) != null)
		{
			final Item[] items = inventoryContainer.getItems();
			int itemPosition = 0;
			if (items.length > 0)
			{

				for (final Item item : items)
				{
					if (item.getId() == itemID)
					{
						final MenuEntry entry = new MenuEntry("", "", itemID, opCode, itemPosition, actionParam, true);
						this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry, MenuEntrySwapHandler.enum2.INVENTORY);
						return true;
					}

					++itemPosition;
				}
			}
		}

		return false;
	}

	public final int DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(final int itemID)
	{
		final ItemContainer inventoryContainer;
		if ((inventoryContainer = this.client.getItemContainer(InventoryID.INVENTORY)) != null)
		{
			final Item[] items = inventoryContainer.getItems();
			int itemPosition = 0;
			if (items.length > 0)
			{
				for (final Item item : items)
				{
					if (item.getId() == itemID)
					{
						return itemPosition;
					}

					++itemPosition;
				}
			}
		}

		return -1;
	}

	public final boolean JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2(final int runeID, final int requiredQuantity)
	{
		if (DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(new int[]{12791}) || DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(new int[]{24416}))
		{
			assert VARBITS_1.length == VARBITS_2.length;

			for (int i = 0; i < VARBITS_1.length; ++i)
			{
				final Varbits amountVarbit = VARBITS_1[i];
				final int amount = this.client.getVar(amountVarbit);
				final Varbits runeVarbit = VARBITS_2[i];
				final DZRunes rune;
				if ((rune = DZRunes.AB1CaddDEdaHI12361JKLM8NO3ka5gw(this.client.getVar(runeVarbit))) != null)
				{
					if (rune.AB1CaddDEdaHI12361JKLM8NO3ka5gw() == runeID && amount >= requiredQuantity)
					{
						return true;
					}

					if (rune.AB1CaddDEdaHI12361JKLM8NO3ka5gw() == runeID)
					{
						return false;
					}
				}
			}
		}

		return false;
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final List<DeadZonePrayerMap> prayers, final boolean disableIfActive, final boolean enableIfDisabled)
	{
		final Iterator<DeadZonePrayerMap> prayers1 = prayers.iterator();

		while (true)
		{
			DeadZonePrayerMap prayer;
			while (true)
			{
				if (!prayers1.hasNext())
				{
					return;
				}

				final Prayer p = Prayer.valueOf((prayer = prayers1.next()).getPrayerName().toUpperCase().replace(" ", "_"));
				if (disableIfActive)
				{
					if (this.client.isPrayerActive(p))
					{
						break;
					}
				}
				else if (!enableIfDisabled || !this.client.isPrayerActive(p))
				{
					break;
				}
			}

			this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(prayer);
		}
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final DeadZonePrayerMap prayer)
	{
		final MenuEntry entry = new MenuEntry("", "", 1, 57, -1, prayer.getEntry(), true);
		this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);

		try
		{
			Thread.sleep(this.AB1CaddDEdaHI12361JKLM8NO3ka5gw());
		}
		catch (final InterruptedException var2)
		{
			var2.printStackTrace();
		}
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final KeyEvent keyEvent)
	{
		String chat = this.client.getVar(VarClientStr.CHATBOX_TYPED_TEXT);

		if (chat.endsWith(String.valueOf(keyEvent.getKeyChar())))
		{
			chat = chat.substring(0, chat.length() - 1);
			this.client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, chat);
		}

	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(Point strechedPoint)
	{
		assert !this.client.isClientThread();

		try
		{
			if (this.client.isStretchedEnabled())
			{
				final Dimension stretched = this.client.getStretchedDimensions();
				final Dimension real = this.client.getRealDimensions();
				final double width = (double) stretched.width / real.getWidth();
				final double height = (double) stretched.height / real.getHeight();
				strechedPoint = new Point((int) ((double) strechedPoint.getX() * width), (int) ((double) strechedPoint.getY() * height));
			}
			this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(501, strechedPoint);
			this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(502, strechedPoint);
			this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(500, strechedPoint);
		}
		catch (final Exception var8)
		{
			LOGGER.info("Failed to handle click");
			var8.printStackTrace();
		}
	}

	private void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int id, final Point point)
	{
		if (point != null)
		{
			final MouseEvent e = new MouseEvent(this.client.getCanvas(), id, System.currentTimeMillis(), 0, point.getX(), point.getY(), 1, false, 1);
			this.client.getCanvas().dispatchEvent(e);
		}

	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final char key)
	{
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(401, key);
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(402, key);
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(400, key);
	}

	private void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int id, final char key)
	{
		final KeyEvent e = new KeyEvent(this.client.getCanvas(), id, System.currentTimeMillis(), 0, 0, key);
		this.client.getCanvas().dispatchEvent(e);
	}

	private void vwxyzQdw3RSTUVwxyz11114XYZ1234()
	{
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw('\u001b', 27, 401);
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw('\u001b', 32, 402);
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw('\u001b', 32, 400);
	}

	public void PQRS23TgasdUVWX114666ce13Abefgh93f9awdf()
	{
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw('\r', 10, 401);
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw('\r', 10, 402);
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw('\r', 10, 400);
	}

	public final void asgn2kd1p2no455mnop2dqrstuvwxyz111146()
	{
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(' ', 32, 401);
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(' ', 32, 402);
		this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(' ', 32, 400);
	}

	private void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final char key, final int keyEvent, final int id)
	{
		final KeyEvent e = new KeyEvent(this.client.getCanvas(), id, System.currentTimeMillis(), 0, keyEvent, key);
		this.client.getCanvas().dispatchEvent(e);
	}

	private static double AB1CaddDEdaHI12361JKLM8NO3ka5gw(final double val, final int min, final int max)
	{
		return Math.max(min, Math.min(max, val));
	}

	public static int jkld2369IJgha561gkkbcFdaw1fa5def(final int min, final int max)
	{
		return (int) (Math.random() * (double) (max - min) + 1.0D + (double) min);
	}

	public static long PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(final int min, final int max)
	{
		return (long) min + (long) (Math.random() * (double) max - (double) min);
	}

	public static int[] AB1CaddDEdaHI12361JKLM8NO3ka5gw(final String string)
	{
		try
		{
			return Arrays.stream(string.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		}
		catch (final Exception var1)
		{
			LOGGER.info("Failed to convert string to int[]: " + string);
			return new int[0];
		}
	}

	public static String[] DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(final String string)
	{
		try
		{
			return string.split(",");
		}
		catch (final Exception var1)
		{
			LOGGER.info("Failed to convert string to String[]: " + string);
			return new String[0];
		}
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final String string, final boolean delay)
	{
		final char[] string1;
		final int var3 = (string1 = string.toCharArray()).length;

		for (int var4 = 0; var4 < var3; ++var4)
		{
			final char c = string1[var4];
			this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(c);
			if (delay)
			{
				try
				{
					Thread.sleep(this.AB1CaddDEdaHI12361JKLM8NO3ka5gw() << 1);
				}
				catch (final Exception var6)
				{
					var6.printStackTrace();
				}
			}
		}

	}

	@Nullable
	public final NPC jkld2369IJgha561gkkbcFdaw1fa5def(final int... ids)
	{
		return this.client.getLocalPlayer() == null ? null : (new NPCQuery()).idEquals(ids).result(this.client).nearestTo(this.client.getLocalPlayer());
	}

	@Nullable
	public final GameObject PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(final int... ids)
	{
		return this.client.getLocalPlayer() == null ? null : (new GameObjectQuery()).idEquals(ids).result(this.client).nearestTo(this.client.getLocalPlayer());
	}

	@Nullable
	public final WallObject asgn2kd1p2no455mnop2dqrstuvwxyz111146(final int... ids)
	{
		return this.client.getLocalPlayer() == null ? null : (new WallObjectQuery()).idEquals(ids).result(this.client).nearestTo(this.client.getLocalPlayer());
	}

	@Nullable
	public final DecorativeObject jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq(final int... ids)
	{
		return this.client.getLocalPlayer() == null ? null : (new DecorativeObjectQuery()).idEquals(ids).result(this.client).nearestTo(this.client.getLocalPlayer());
	}

	@Nullable
	public final GroundObject cdefghi367869abcdefhJKL1234AB1Cad(final int... ids)
	{
		return this.client.getLocalPlayer() == null ? null : (new GroundObjectQuery()).idEquals(ids).result(this.client).nearestTo(this.client.getLocalPlayer());
	}

	public final List<GameObject> vwxyzQdw3RSTUVwxyz11114XYZ1234(final int... ids)
	{
		return this.client.getLocalPlayer() == null ? new ArrayList<>() : (new GameObjectQuery()).idEquals(ids).result(this.client).list;
	}

	private List<WallObject> FGw3gHIJdaw1faKLM8NO3ka5gwPQRS23(final int... ids)
	{
		return this.client.getLocalPlayer() == null ? new ArrayList<>() : (new WallObjectQuery()).idEquals(ids).result(this.client).list;
	}

	private List<DecorativeObject> IOPQRSTUV4abcdefgJKLM8NO3ka5gM8(final int... ids)
	{
		return this.client.getLocalPlayer() == null ? new ArrayList<>() : (new DecorativeObjectQuery()).idEquals(ids).result(this.client).list;
	}

	private List<GroundObject> VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3(final int... ids)
	{
		return this.client.getLocalPlayer() == null ? new ArrayList<>() : (new GroundObjectQuery()).idEquals(ids).result(this.client).list;
	}

	@Nullable
	private TileObject AB35raDWsFGHda212365IJKL12tfa1MNO(final int... ids)
	{
		final GameObject gameObject;
		if ((gameObject = this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(ids)) != null)
		{
			return gameObject;
		}
		else
		{
			final WallObject wallObject;
			if ((wallObject = this.asgn2kd1p2no455mnop2dqrstuvwxyz111146(ids)) != null)
			{
				return wallObject;
			}
			else
			{
				final DecorativeObject decorativeObject;
				return (decorativeObject = this.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq(ids)) != null ? decorativeObject : this.cdefghi367869abcdefhJKL1234AB1Cad(ids);
			}
		}
	}

	public final enum3 s6641asgn2kd1dasgha1333(final int... ids)
	{
		if (this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(ids) != null)
		{
			return enum3.GAMEOBJECT;
		}
		else if (this.asgn2kd1p2no455mnop2dqrstuvwxyz111146(ids) != null)
		{
			return enum3.WALLOBJECT;
		}
		else if (this.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq(ids) != null)
		{
			return enum3.DECOROBJECT;
		}
		else
		{
			return this.cdefghi367869abcdefhJKL1234AB1Cad(ids) != null ? enum3.GROUNDOBJECT : enum3.NULL;
		}
	}

	public enum enum3
	{
		NULL,
		GAMEOBJECT,
		WALLOBJECT,
		DECOROBJECT,
		GROUNDOBJECT
	}

	private enum enum1
	{
		NPC,
		BoothObject,
		ChestObject
	}
}
