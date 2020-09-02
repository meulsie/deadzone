package net.runelite.client.plugins.DeadZoneConstruction;

import com.google.inject.Provides;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.events.WidgetLoaded;
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
import net.runelite.client.util.ColorUtil;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Extension
@PluginDescriptor(
	name = "DZ Con Helper",
	description = "Configure DeadZone Construction Helper Plugin",
	tags = {"deadzone", "construction"},
	type = PluginType.SYSTEM,
	enabledByDefault = false
)
@PluginDependency(DeadZoneAPI.class)
public class DZConPlugin extends Plugin implements KeyListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DZConPlugin.class);

	@Inject
	private Client client;

	@Inject
	private DeadZoneAPI deadZoneAPI;

	private DeadZoneUtilities deadZoneUtilities;

	@Inject
	private DZConOverlay dzConOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private DZConConfig config;

	@Inject
	private MenuEntrySwapHandler menuEntrySwapHandler;

	@Inject
	private KeyManager keyManager;

	private ScheduledExecutorService scheduledExecutorService;

	boolean scheduled;
	boolean isActive;

	private DZConInterface dzConInterface;
	private Instant instant;

	@Provides
	private static DZConConfig AB1CaddDEdaHI12361JKLM8NO3ka5gw(final ConfigManager configManager)
	{
		return configManager.getConfig(DZConConfig.class);
	}

	protected void startUp()
	{
		deadZoneUtilities = deadZoneAPI.deadZoneUtilities;
		keyManager.registerKeyListener(this);
		overlayManager.add(dzConOverlay);
		scheduledExecutorService = deadZoneAPI.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178;
	}

	protected void shutDown()
	{
		keyManager.unregisterKeyListener(this);
		overlayManager.remove(dzConOverlay);
	}

	@Subscribe
	private void onGameTick(final GameTick event)
	{
		if (dzConInterface != null && isActive)
		{
			if (!isTimeOut())
			{
				LOGGER.info("Timeout limit reached, shutting down!");
				client.addChatMessage(
					ChatMessageType.GAMEMESSAGE,
					"",
					ColorUtil.wrapWithColorTag("| ", Color.yellow)
						+ ColorUtil.wrapWithColorTag("Construction Helper", Color.green)
						+ ColorUtil.wrapWithColorTag(" | ", Color.yellow)
						+ "Timeout limit reached, shutting down!",
					null);
				reset();
				return;
			}

			dzConInterface.onGameTick();
		}

	}

	@Subscribe
	private void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() != GameState.LOGGED_IN && isActive)
		{
			reset();
		}

	}

	@Subscribe
	private void onAnimationChanged(final AnimationChanged event)
	{
		if (dzConInterface != null)
		{
			dzConInterface.onAnimationedChanged(event);
		}

	}

	@Subscribe
	private void onGameObjectSpawned(final GameObjectSpawned event)
	{
		if (dzConInterface != null)
		{
			dzConInterface.onGameObjectSpawned(event);
		}

	}

	@Subscribe
	private void onWallObjectSpawned(final WallObjectSpawned event)
	{
		if (dzConInterface != null)
		{
			dzConInterface.onWallObjectSpawned(event);
		}

	}

	@Subscribe
	private void onDecorativeObjectSpawned(final DecorativeObjectSpawned event)
	{
		if (dzConInterface != null)
		{
			dzConInterface.onDecorativeObectSpawned(event);
		}

	}

	@Subscribe
	private void onWidgetLoaded(final WidgetLoaded event)
	{
		if (dzConInterface != null)
		{
			dzConInterface.onWidgetLoaded(event);
		}

	}

	final boolean isActive()
	{
		return isActive;
	}

	private void setInstant()
	{
		instant = Instant.now();
	}

	private boolean isTimeOut()
	{
		if (instant != null)
		{
			final Duration timeout = Duration.ofMinutes(config.timeout());
			return Duration.between(instant, Instant.now()).compareTo(timeout) < 0;
		}
		else
		{
			return false;
		}
	}

	final long getTimeLeft()
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

	private void start()
	{
		switch (config.skillingMethod())
		{
			case Larders:
			case Teak_Benches:
			case Mahogany_Tables:
			case Dungeon_Doors:
			case Cape_Racks:
				dzConInterface = new DZConMain(this, client, deadZoneUtilities, config, menuEntrySwapHandler, scheduledExecutorService);
			default:
				isActive = true;
				dzConInterface.activate();
				break;
		}
	}

	private void init()
	{
		if (scheduledExecutorService != null)
		{
			scheduled = false;
			setInstant();
			start();
		}

	}

	private void reset()
	{
		instant = null;
		dzConInterface = null;
		isActive = false;
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
			if (!isActive)
			{
				init();
				return;
			}

			reset();
		}

	}

	@Override
	public void keyReleased(final KeyEvent keyEvent)
	{
	}

	enum Type
	{
		GameObject,
		Decoration,
		WallObject;
	}
}
