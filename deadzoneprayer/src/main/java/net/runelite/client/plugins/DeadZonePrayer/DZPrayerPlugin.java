package net.runelite.client.plugins.DeadZonePrayer;

import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.DeadZoneAPI.DeadZoneAPI;
import net.runelite.client.plugins.DeadZoneAPI.DeadZonePrayerMap;
import net.runelite.client.plugins.DeadZoneAPI.DeadZoneUtilities;
import net.runelite.client.plugins.DeadZoneAPI.MenuEntrySwapHandler;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
@Extension
@PluginDescriptor(
	name = "DZ Prayer Helper",
	description = "Configure DeadZone Prayer Helper",
	tags = {"deadzone", "prayer", "dz"},
	type = PluginType.SYSTEM,
	enabledByDefault = false
)
@PluginDependency(DeadZoneAPI.class)
public class DZPrayerPlugin extends Plugin implements KeyListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DZPrayerPlugin.class);

	@Inject
	private Client client;

	@Inject
	private DeadZoneAPI deadZoneAPI;

	@Inject
	private DeadZoneUtilities deadZoneUtilities;

	@Inject
	private KeyManager keyManager;

	@Inject
	private MenuEntrySwapHandler menuEntrySwapHandler;

	@Inject
	private DZPrayerConfig config;

	private ScheduledExecutorService scheduledExecutorService;

	private boolean bool1;
	private boolean bool2;
	private int idx;

	private static final int[] NMZ_REGION_IDS = new int[]{9033};

	private final List<DeadZonePrayerMap> prayers = new LinkedList<>();
	private final List<DeadZonePrayerMap> p1 = new LinkedList<>();
	private final List<DeadZonePrayerMap> p2 = new LinkedList<>();
	private final List<DeadZonePrayerMap> p3 = new LinkedList<>();
	private final List<DeadZonePrayerMap> p4 = new LinkedList<>();
	private final List<DeadZonePrayerMap> p5 = new LinkedList<>();
	private final List<DeadZonePrayerMap> p6 = new LinkedList<>();

	@Provides
	private static DZPrayerConfig getConfig(final ConfigManager configManager)
	{
		return configManager.getConfig(DZPrayerConfig.class);
	}

	protected void startUp()
	{
		keyManager.registerKeyListener(this);
		scheduledExecutorService = deadZoneAPI.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178;
		parseConfig();
	}

	protected void shutDown()
	{
		keyManager.unregisterKeyListener(this);
		p1.clear();
		p2.clear();
		p3.clear();
		p4.clear();
		p5.clear();
		p6.clear();
	}

	private boolean inNmzRegion()
	{
		if (client.getLocalPlayer() == null)
		{
			return false;
		}
		else
		{
			return client.getLocalPlayer().getWorldLocation().getPlane() > 0 && Arrays.equals(client.getMapRegions(), NMZ_REGION_IDS);
		}
	}

	@Subscribe
	private void onGameTick(final GameTick event)
	{
		if (bool2 && !bool1)
		{
			if (config.onlyInNMZ() && !inNmzRegion())
			{
				bool1 = true;
				scheduledExecutorService.schedule(() -> {
					if (config.disableOnDeactivation() && client.getVar(Varbits.QUICK_PRAYER) == 1)
					{
						final MenuEntry entry = new MenuEntry("", "", 1, 57, -1, 10485774, true);
						menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
					}

					bool1 = false;
				}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
				return;
			}

			bool1 = true;
			scheduledExecutorService.schedule(() -> {
				final MenuEntry entry = new MenuEntry("", "", 1, 57, -1, 10485774, true);
				if (client.getVar(Varbits.QUICK_PRAYER) == 1)
				{
					menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);

					try
					{
						Thread.sleep(deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw());
					}
					catch (final InterruptedException var3)
					{
						var3.printStackTrace();
					}
				}

				menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
				bool1 = false;
			}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw() / 2L, TimeUnit.MILLISECONDS);
		}

	}

	@Subscribe
	private void onGameStateChanged(final GameStateChanged event)
	{
		if (client.getGameState() == GameState.LOGIN_SCREEN)
		{
			prayers.clear();
			idx = 0;
			bool1 = false;
			bool2 = false;
		}

	}

	@Subscribe
	private void onConfigChanged(final ConfigChanged event)
	{
		if (event.getGroup().equals("DZPrayerConfig"))
		{
			parseConfig();
		}
	}

	private void parseConfig()
	{
		p1.clear();
		p2.clear();
		p3.clear();
		p4.clear();
		p5.clear();
		p6.clear();

		if (config.prayerOneEnabled())
		{
			addPrayers(config.prayerItemsOne(), 1);
		}

		if (config.prayerTwoEnabled())
		{
			addPrayers(config.prayerItemsTwo(), 2);
		}

		if (config.prayerThreeEnabled())
		{
			addPrayers(config.prayerItemsThree(), 3);
		}

		if (config.prayerFourEnabled())
		{
			addPrayers(config.prayerItemsFour(), 4);
		}

		if (config.prayerFiveEnabled())
		{
			addPrayers(config.prayerItemsFive(), 5);
		}

		if (config.prayerSixEnabled())
		{
			addPrayers(config.prayerItemsSix(), 6);
		}

	}

	private void addPrayers(final String prayerItems, final int prayerIndex)
	{
		if (!prayerItems.isEmpty() && !prayerItems.isBlank())
		{
			final String[] prayers = DeadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(prayerItems);

			for (String prayer : prayers)
			{
				prayer = prayer.trim();

				try
				{
					final DeadZonePrayerMap deadZonePrayerMap = DeadZonePrayerMap.valueOf(prayer.toUpperCase().replace(" ", "_"));

					switch (prayerIndex)
					{
						case 1:
							p1.add(deadZonePrayerMap);
							break;
						case 2:
							p2.add(deadZonePrayerMap);
							break;
						case 3:
							p3.add(deadZonePrayerMap);
							break;
						case 4:
							p4.add(deadZonePrayerMap);
							break;
						case 5:
							p5.add(deadZonePrayerMap);
							break;
						case 6:
							p6.add(deadZonePrayerMap);
					}
				}
				catch (final Exception var6)
				{
					LOGGER.info(String.valueOf(var6));
				}
			}

		}
	}

	private void activatePrayer(final List<DeadZonePrayerMap> togglePrayers, final int thisToggleIndex)
	{
		if (!bool1)
		{
			bool1 = true;

			scheduledExecutorService.submit(() -> {
				if (config.handlePrevPrayers() && thisToggleIndex != idx && !prayers.isEmpty() && idx != 0)
				{
					deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(prayers, true, false);
				}

				prayers.clear();

				for (final DeadZonePrayerMap prayer : togglePrayers)
				{
					deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(prayer);
					prayers.add(prayer);
				}

				idx = thisToggleIndex;
				bool1 = false;
			});
		}
	}

	@Override
	public void keyPressed(final KeyEvent keyEvent)
	{
		if (client.getGameState() == GameState.LOGGED_IN && scheduledExecutorService != null)
		{
			if (config.togglePrayerOne().matches(keyEvent) && config.prayerOneEnabled() && !bool2 && client.getCanvas().hasFocus())
			{
				activatePrayer(p1, 1);
				return;
			}

			if (config.togglePrayerTwo().matches(keyEvent) && config.prayerTwoEnabled() && !bool2 && client.getCanvas().hasFocus())
			{
				activatePrayer(p2, 2);
				return;
			}

			if (config.togglePrayerThree().matches(keyEvent) && config.prayerThreeEnabled() && !bool2 && client.getCanvas().hasFocus())
			{
				activatePrayer(p3, 3);
				return;
			}

			if (config.togglePrayerFour().matches(keyEvent) && config.prayerFourEnabled() && !bool2 && client.getCanvas().hasFocus())
			{
				activatePrayer(p4, 4);
				return;
			}

			if (config.togglePrayerFive().matches(keyEvent) && config.prayerFiveEnabled() && !bool2 && client.getCanvas().hasFocus())
			{
				activatePrayer(p5, 5);
				return;
			}

			if (config.togglePrayerSix().matches(keyEvent) && config.prayerSixEnabled() && !bool2 && client.getCanvas().hasFocus())
			{
				activatePrayer(p6, 6);
				return;
			}

			if (config.prayerFlickKey().matches(keyEvent) && client.getCanvas().hasFocus())
			{
				if (bool2)
				{
					bool2 = false;
					bool1 = true;
					scheduledExecutorService.schedule(() -> {
						if (config.disableOnDeactivation() && client.getVar(Varbits.QUICK_PRAYER) == 1)
						{
							final MenuEntry entry = new MenuEntry("", "", 1, 57, -1, 10485774, true);
							menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
						}

						bool1 = false;
					}, 800L, TimeUnit.MILLISECONDS);
					return;
				}

				if (client.getVar(Varbits.QUICK_PRAYER) == 0)
				{
					final MenuEntry entry = new MenuEntry("", "", 1, 57, -1, 10485774, true);
					menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
				}

				bool2 = true;
			}
		}

	}

	@Override
	public void keyReleased(final KeyEvent keyEvent)
	{
		if (config.clearChat())
		{
			if (keyEvent.getKeyCode() == config.togglePrayerOne().getKeyCode())
			{
				deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(keyEvent);
				return;
			}

			if (keyEvent.getKeyCode() == config.togglePrayerTwo().getKeyCode())
			{
				deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(keyEvent);
				return;
			}

			if (keyEvent.getKeyCode() == config.togglePrayerThree().getKeyCode())
			{
				deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(keyEvent);
				return;
			}

			if (keyEvent.getKeyCode() == config.togglePrayerFour().getKeyCode())
			{
				deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(keyEvent);
				return;
			}

			if (keyEvent.getKeyCode() == config.togglePrayerFive().getKeyCode())
			{
				deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(keyEvent);
				return;
			}

			if (keyEvent.getKeyCode() == config.togglePrayerSix().getKeyCode())
			{
				deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(keyEvent);
				return;
			}

			if (keyEvent.getKeyCode() == config.prayerFlickKey().getKeyCode())
			{
				deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(keyEvent);
			}
		}

	}

	@Override
	public void keyTyped(final KeyEvent keyEvent)
	{
	}
}
