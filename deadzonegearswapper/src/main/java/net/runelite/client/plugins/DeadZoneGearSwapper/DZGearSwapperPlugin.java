package net.runelite.client.plugins.DeadZoneGearSwapper;

import com.google.inject.Provides;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.MenuEntry;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.DeadZoneAPI.DeadZoneAPI;
import net.runelite.client.plugins.DeadZoneAPI.DeadZoneUtilities;
import net.runelite.client.plugins.DeadZoneAPI.MenuEntrySwapHandler;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.util.ColorUtil;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Extension
@PluginDescriptor(
	name = "DZ Gear Swapper",
	description = "Configure DeadZone Gear Swapper Plugin",
	tags = {"deadzone", "gear", "swapper"},
	type = PluginType.SYSTEM,
	enabledByDefault = false
)
@PluginDependency(DeadZoneAPI.class)
public class DZGearSwapperPlugin extends Plugin implements KeyListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DZGearSwapperPlugin.class);

	@Inject
	private Client client;

	@Inject
	private DeadZoneAPI deadZoneAPI;

	@Inject
	private DeadZoneUtilities deadZoneUtilities;

	@Inject
	private DZGearSwapperConfig dzGearSwapperConfig;

	@Inject
	private MenuEntrySwapHandler menuEntrySwapHandler;

	@Inject
	private KeyManager keyManager;

	private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

	private boolean isBusy;

	@Provides
	private static DZGearSwapperConfig getConfig(final ConfigManager configManager)
	{
		return configManager.getConfig(DZGearSwapperConfig.class);
	}

	protected void startUp()
	{
		keyManager.registerKeyListener(this);
		scheduledThreadPoolExecutor = deadZoneAPI.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178;
		isBusy = false;
	}

	protected void shutDown()
	{
		keyManager.unregisterKeyListener(this);
	}

	private void swapGear(final String swapString, final boolean enableSpec)
	{
		try
		{
			isBusy = true;
			final int[] ids = DeadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(swapString);
			final List<Item> items = deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(ids);
			int delayAmount = 0;

			for (final Object o : items)
			{
				final Item item = (Item) o;
				final int finalItemPosition = deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(item.getId());
				if (finalItemPosition != -1)
				{
					scheduledThreadPoolExecutor.schedule(() -> {
						final MenuEntry entry = new MenuEntry("", "", item.getId(), 34, finalItemPosition, 9764864, true);
						menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
					}, delayAmount, TimeUnit.MILLISECONDS);
					delayAmount = (int) ((long) delayAmount + deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw());
				}
			}

			if (enableSpec)
			{
				if (dzGearSwapperConfig.pvpSpec())
				{
					scheduledThreadPoolExecutor.schedule(() -> {
						final MenuEntry entry = new MenuEntry("", "", 1, 57, -1, 38862884, true);
						menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
					}, delayAmount, TimeUnit.MILLISECONDS);
				}
				else
				{
					scheduledThreadPoolExecutor.schedule(() -> {
						final MenuEntry entry = new MenuEntry("", "", 1, 57, -1, 10485790, true);
						menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
					}, delayAmount, TimeUnit.MILLISECONDS);
				}
				delayAmount = (int) ((long) delayAmount + deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw());
			}

			scheduledThreadPoolExecutor.schedule(() -> {
				isBusy = false;
			}, delayAmount, TimeUnit.MILLISECONDS);
		}
		catch (final Exception var6)
		{
			LOGGER.info("Failed to swap gear!");
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", ColorUtil.wrapWithColorTag("| ", Color.yellow) + ColorUtil.wrapWithColorTag("Gear Swapper", Color.green) + ColorUtil.wrapWithColorTag(" | ", Color.yellow) + "Failed to swap gear!", null);
			isBusy = false;
			var6.printStackTrace();
		}
	}

	public void keyTyped(final KeyEvent keyEvent)
	{
	}

	public void keyPressed(final KeyEvent keyEvent)
	{
		if (client.getGameState() == GameState.LOGGED_IN && client.getCanvas().hasFocus() && !isBusy && scheduledThreadPoolExecutor != null)
		{
			if (dzGearSwapperConfig.toggleKey1().matches(keyEvent))
			{
				swapGear(dzGearSwapperConfig.gearSwap1(), dzGearSwapperConfig.autoSpec1());
				return;
			}

			if (dzGearSwapperConfig.toggleKey2().matches(keyEvent))
			{
				swapGear(dzGearSwapperConfig.gearSwap2(), dzGearSwapperConfig.autoSpec2());
				return;
			}

			if (dzGearSwapperConfig.toggleKey3().matches(keyEvent))
			{
				swapGear(dzGearSwapperConfig.gearSwap3(), dzGearSwapperConfig.autoSpec3());
			}
		}

	}

	public void keyReleased(final KeyEvent keyEvent)
	{
		if (dzGearSwapperConfig.clearChat() && (dzGearSwapperConfig.toggleKey1().matches(keyEvent) || dzGearSwapperConfig.toggleKey2().matches(keyEvent) || dzGearSwapperConfig.toggleKey3().matches(keyEvent)))
		{
			deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(keyEvent);
		}

	}
}
