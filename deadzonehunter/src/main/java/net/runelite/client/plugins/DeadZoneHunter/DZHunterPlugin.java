package net.runelite.client.plugins.DeadZoneHunter;

import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.DeadZoneAPI.DeadZoneAPI;
import net.runelite.client.plugins.DeadZoneAPI.DeadZoneUtilities;
import net.runelite.client.plugins.DeadZoneAPI.MenuEntrySwapHandler;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
@Extension
@PluginDescriptor(
	name = "DZ Hunter Helper",
	description = "Configure DeadZone Hunter Plugin",
	tags = {"deadzone", "johnny", "bot", "helper"},
	type = PluginType.SYSTEM,
	enabledByDefault = false
)
@PluginDependency(DeadZoneAPI.class)
public class DZHunterPlugin extends Plugin implements KeyListener
{
	private static final Logger JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2 = LoggerFactory.getLogger(DZHunterPlugin.class);

	@Inject
	private Client client;

	@Inject
	private DeadZoneAPI deadZoneAPI;

	private DeadZoneUtilities deadZoneUtilities;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private DZHunterOverlay dzHunterOverlay;

	@Inject
	private DZHunterConfig config;

	@Inject
	private MenuEntrySwapHandler menuEntrySwapHandler;

	@Inject
	private KeyManager keyManager;

	boolean bool1;

	int int1;

	private ScheduledExecutorService scheduledExecutorService;

	private DZHunterInterface dzHunterInterface;

	private Instant instant;

	private final List<Integer> itemIDs = new LinkedList<>();

	@Provides
	private static DZHunterConfig AB1CaddDEdaHI12361JKLM8NO3ka5gw(final ConfigManager configManager)
	{
		return configManager.getConfig(DZHunterConfig.class);
	}

	protected void startUp()
	{
		deadZoneUtilities = deadZoneAPI.deadZoneUtilities;
		keyManager.registerKeyListener(this);
		overlayManager.add(dzHunterOverlay);
		scheduledExecutorService = deadZoneAPI.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178;
		dzHunterInterface = null;
	}

	protected void shutDown()
	{
		keyManager.unregisterKeyListener(this);
		overlayManager.remove(dzHunterOverlay);
		dzHunterInterface = null;
	}

	@Subscribe
	private void onGameTick(final GameTick event)
	{
		if (dzHunterInterface != null)
		{
			if (!PQRS23TgasdUVWX114666ce13Abefgh93f9awdf())
			{
				JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2.info("Timeout limit reached! Stopping hunter plugin...");
				asgn2kd1p2no455mnop2dqrstuvwxyz111146();
			}

			if (config.dropItems() && deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178() >= config.dropThreshold() && deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(DeadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(config.itemsToDrop())))
			{
				JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2.info("Dropping items!");
				jkld2369IJgha561gkkbcFdaw1fa5def();
			}

			if (client.getVarpValue(173) == 0 && !bool1 && client.getEnergy() >= 30)
			{
				JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2();
			}

			dzHunterInterface.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
		}

	}

	private void JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2()
	{
		menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(new MenuEntry("Toggle Run", "", 1, 57, -1, 10485782, false));
	}

	private void jkld2369IJgha561gkkbcFdaw1fa5def()
	{
		final ItemContainer inventoryContainer = client.getItemContainer(InventoryID.INVENTORY);
		long delay = 0L;
		if (inventoryContainer != null)
		{
			final Item[] items = inventoryContainer.getItems();
			if (items.length > 0)
			{
				int itemPosition = 0;
				final int var5 = items.length;

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

			bool1 = true;
			scheduledExecutorService.schedule(() -> {
				bool1 = false;
			}, delay, TimeUnit.MILLISECONDS);
		}

	}

	private void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int itemID, final int itemPosition, final long delay)
	{
		bool1 = true;
		scheduledExecutorService.schedule(() -> {
			final MenuEntry entry = new MenuEntry("", "", itemID, 37, itemPosition, 9764864, true);
			menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
		}, delay, TimeUnit.MILLISECONDS);
	}

	@Subscribe
	private void onAnimationChanged(final AnimationChanged event)
	{
		if (dzHunterInterface != null)
		{
			dzHunterInterface.onAnimationChanged(event);
		}

	}

	@Subscribe
	private void onGameObjectSpawned(final GameObjectSpawned object)
	{
		if (dzHunterInterface != null)
		{
			dzHunterInterface.onGameObjectSpawned(object);
		}

	}

	@Subscribe
	private void onGameObjectDespawned(final GameObjectDespawned object)
	{
		if (dzHunterInterface != null)
		{
			dzHunterInterface.onGameObjectDespawned(object);
		}

	}

	@Subscribe
	private void onItemSpawned(final ItemSpawned itemSpawned)
	{
		if (dzHunterInterface != null)
		{
			dzHunterInterface.onItemSpawned(itemSpawned);
		}

	}

	@Subscribe
	private void onItemDespawned(final ItemDespawned itemDespawned)
	{
		if (dzHunterInterface != null)
		{
			dzHunterInterface.onItemDespawned(itemDespawned);
		}

	}

	final boolean AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		return dzHunterInterface != null;
	}

	private boolean PQRS23TgasdUVWX114666ce13Abefgh93f9awdf()
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

	private void asgn2kd1p2no455mnop2dqrstuvwxyz111146()
	{
		dzHunterInterface.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2();
		dzHunterInterface = null;
	}

	private void jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq()
	{
		switch (config.skillingMethod())
		{
			case Red_Chins:
			case Black_Chins:
				dzHunterInterface = new DZHunterChins(this, client, deadZoneUtilities, menuEntrySwapHandler, scheduledExecutorService);
				break;
			case Salamanders:
				dzHunterInterface = new DZHunterSalamanders(this, client, deadZoneUtilities, config, menuEntrySwapHandler, scheduledExecutorService);
		}

		dzHunterInterface.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178();
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
			if (dzHunterInterface == null && scheduledExecutorService != null)
			{
				if (config.dropItems())
				{
					try
					{
						if (config.itemsToDrop().isEmpty() || config.itemsToDrop().isBlank())
						{
							JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2.info("Drop Items enabled without any items specified to drop! Stopping hunter plugin...");
							return;
						}

						final int[] keyEvent1 = DeadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(config.itemsToDrop());

						for (final int i : keyEvent1)
						{
							itemIDs.add(i);
						}
					}
					catch (final Exception var5)
					{
						JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2.info("Failed to parse Drop Items. Stopping hunter plugin...");
						var5.printStackTrace();
						return;
					}
				}

				int1 = config.distanceCheck() * 124;
				instant = Instant.now();
				jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq();
				return;
			}

			if (dzHunterInterface != null)
			{
				instant = null;
				asgn2kd1p2no455mnop2dqrstuvwxyz111146();
			}
		}

	}

	@Override
	public void keyReleased(final KeyEvent keyEvent)
	{
	}
}
