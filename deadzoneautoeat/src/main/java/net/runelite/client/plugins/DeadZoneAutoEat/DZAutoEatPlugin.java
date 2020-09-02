package net.runelite.client.plugins.DeadZoneAutoEat;

import com.google.inject.Provides;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.MenuEntry;
import net.runelite.api.Skill;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.DeadZoneAPI.DeadZoneAPI;
import net.runelite.client.plugins.DeadZoneAPI.DeadZonePrayerRestoreTypes;
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

@SuppressWarnings("unused")
@Extension
@PluginDescriptor(
	name = "DZ Auto Eat",
	description = "Configure DeadZone Auto Eat",
	tags = {"deadzone", "auto", "eat"},
	type = PluginType.SYSTEM,
	enabledByDefault = false
)
@PluginDependency(DeadZoneAPI.class)
public class DZAutoEatPlugin extends Plugin implements KeyListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DZAutoEatPlugin.class);

	@Inject
	private Client client;

	@Inject
	private DeadZoneAPI deadZoneAPI;

	@Inject
	private DeadZoneUtilities deadZoneUtilities;

	@Inject
	private DZAutoEatConfig config;

	@Inject
	private MenuEntrySwapHandler menuEntrySwapHandler;

	@Inject
	private KeyManager keyManager;

	private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor1;
	private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2;

	private int[] intArr1;

	private int int1;
	private final int int2 = 3144;
	private final int int3 = 23533;

	private boolean bool1;
	private boolean bool2;
	private boolean bool3;

	private final List<Integer> integerList = Arrays.asList(6691, 6689, 6687, 6685, 23575, 23577, 23579, 23581);

	@Provides
	private static DZAutoEatConfig getConfig(final ConfigManager configManager)
	{
		return configManager.getConfig(DZAutoEatConfig.class);
	}

	protected void startUp()
	{
		this.keyManager.registerKeyListener(this);
		this.scheduledThreadPoolExecutor1 = this.deadZoneAPI.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178;
		this.bool3 = false;
		this.bool2 = true;
		this.bool1 = false;
		this.int1 = this.client.getBoostedSkillLevel(Skill.HITPOINTS);
		this.scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new DiscardPolicy());
		final String var10001 = ColorUtil.wrapWithColorTag("| ", Color.yellow);
		final String VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3 = var10001 + ColorUtil.wrapWithColorTag("Auto-Eat", Color.green) + ColorUtil.wrapWithColorTag(" | ", Color.yellow);
		this.jkld2369IJgha561gkkbcFdaw1fa5def();
		this.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178();
	}

	protected void shutDown()
	{
		this.keyManager.unregisterKeyListener(this);
		this.bool2 = false;
	}

	@Subscribe
	private void onConfigChanged(final ConfigChanged event)
	{
		if (event.getGroup().equals("DZAutoEatConfig"))
		{
			this.jkld2369IJgha561gkkbcFdaw1fa5def();
		}

	}

	@Subscribe
	private void onGameTick(final GameTick event)
	{
		if (!this.bool1 && !this.bool3)
		{
			if (this.config.autoPrayerPot() && this.client.getBoostedSkillLevel(Skill.PRAYER) <= this.config.prayerThreshold())
			{
				if (this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(DeadZonePrayerRestoreTypes.PRAYERPOT.AB1CaddDEdaHI12361JKLM8NO3ka5gw()))
				{
					this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(0);
					return;
				}

				if (this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(DeadZonePrayerRestoreTypes.SUPER_RESTOREPOT.AB1CaddDEdaHI12361JKLM8NO3ka5gw()))
				{
					this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(1);
					return;
				}

				if (this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(DeadZonePrayerRestoreTypes.SANFEWPOT.AB1CaddDEdaHI12361JKLM8NO3ka5gw()))
				{
					this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(2);
					return;
				}

				if (this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(DeadZonePrayerRestoreTypes.BELIGHTED_SUPER_RESTORE.AB1CaddDEdaHI12361JKLM8NO3ka5gw()))
				{
					this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(3);
					return;
				}
			}

			if (this.config.autoStaminaPot() && this.client.getEnergy() <= this.config.staminaThreshold() && (this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(DZAutoEatStamina.STAMINA_POTION.getItems()) || this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(DZAutoEatStamina.SUPER_ENERGY.getItems())))
			{
				this.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
			}
		}
	}

	private void AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		this.bool1 = true;
		this.scheduledThreadPoolExecutor1.schedule(() -> {
			final Set<Integer> var1 = DZAutoEatStamina.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178();

			for (final Object o : var1)
			{
				final int itemID = (Integer) o;
				if (this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(new int[]{itemID}))
				{
					this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(itemID, 33, 9764864);
					break;
				}
			}

			this.bool1 = false;
		}, this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
	}

	private void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int index)
	{
		this.bool1 = true;
		this.scheduledThreadPoolExecutor1.schedule(() -> {
			final int[] index1;
			switch (index)
			{
				case 1:
					index1 = DeadZonePrayerRestoreTypes.SUPER_RESTOREPOT.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
					break;
				case 2:
					index1 = DeadZonePrayerRestoreTypes.SANFEWPOT.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
					break;
				case 3:
					index1 = DeadZonePrayerRestoreTypes.BELIGHTED_SUPER_RESTORE.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
					break;
				default:
					index1 = DeadZonePrayerRestoreTypes.PRAYERPOT.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
			}

			final int var2 = index1.length;

			for (final int itemID : index1)
			{
				if (this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(new int[]{itemID}))
				{
					this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(itemID, 33, 9764864);
					break;
				}
			}

			this.bool1 = false;
		}, this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
	}

	private void DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		this.scheduledThreadPoolExecutor2.execute(() -> {
			try
			{
				for (; this.bool2; Thread.sleep(5L))
				{
					if (this.client.getGameState() != GameState.LOGIN_SCREEN && this.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2())
					{
						if (!this.config.PVPT1Activate() && !this.config.PVPT2Activate() && !this.config.PVPT2Activate() && this.config.autoEat() && !this.bool3 && !this.bool1 && this.client.getBoostedSkillLevel(Skill.HITPOINTS) <= this.config.hpThreshold() && this.client.getBoostedSkillLevel(Skill.HITPOINTS) > 0)
						{
							this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf();
						}

						if (!this.bool3 && !this.bool1 && this.client.getBoostedSkillLevel(Skill.HITPOINTS) > 0)
						{
							if (this.config.PVPT1Activate() && this.client.getBoostedSkillLevel(Skill.HITPOINTS) <= this.config.PVPT1HPTheshold())
							{
								this.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(1);
							}
							else if (this.config.PVPT2Activate() && this.client.getBoostedSkillLevel(Skill.HITPOINTS) <= this.config.PVPT2HPTheshold())
							{
								this.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(2);
							}
							else if (this.config.PVPT3Activate() && this.client.getBoostedSkillLevel(Skill.HITPOINTS) <= this.config.PVPT3HPTheshold())
							{
								this.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(3);
							}
						}
					}
				}

			}
			catch (final Exception var2)
			{
				LOGGER.info("Failed to handle Health Checker!");
				var2.printStackTrace();
			}
		});
	}

	private boolean JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2()
	{
		if (this.int1 != this.client.getBoostedSkillLevel(Skill.HITPOINTS))
		{
			this.int1 = this.client.getBoostedSkillLevel(Skill.HITPOINTS);
			return true;
		}
		else
		{
			return false;
		}
	}

	private void jkld2369IJgha561gkkbcFdaw1fa5def()
	{
		try
		{
			this.intArr1 = DeadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(this.config.foodID());
			LOGGER.info("Successfully parsed food IDs");
		}
		catch (final Exception var1)
		{
			LOGGER.info("Failed to parse food IDs");
		}
	}

	private void DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(int performedActions)
	{
		LOGGER.info("Executing PVP Eat!");
		this.bool3 = true;
		int actionsToPerform = 0;
		List<Integer> var3 = null;

		try
		{
			switch (performedActions)
			{
				case 1:
					actionsToPerform = this.config.PVPT1Type().getTotalActions();
					var3 = IntStream.of(this.config.PVPT1Type().getItemIds()).boxed().collect(Collectors.toList());
					break;
				case 2:
					actionsToPerform = this.config.PVPT2Type().getTotalActions();
					var3 = IntStream.of(this.config.PVPT2Type().getItemIds()).boxed().collect(Collectors.toList());
					break;
				case 3:
					actionsToPerform = this.config.PVPT3Type().getTotalActions();
					var3 = IntStream.of(this.config.PVPT3Type().getItemIds()).boxed().collect(Collectors.toList());
			}

			if (actionsToPerform != 0)
			{
				long delayAmount = 0L;
				performedActions = 0;

				for (final Object o : var3)
				{
					final Integer id = (Integer) o;
					final int var7 = this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(id);
					if (var7 != -1)
					{
						if (performedActions != 0)
						{
							delayAmount += this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
						}

						this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(id, delayAmount);
						final boolean var10000 = this.integerList.contains(id);
						++performedActions;
						if (var10000 && performedActions < actionsToPerform)
						{
							final int finalKaramPosition;
							final short itemID;
							if (this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(new int[]{3144}))
							{
								finalKaramPosition = this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(3144);
								itemID = 3144;
							}
							else
							{
								finalKaramPosition = this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(23533);
								itemID = 23533;
							}

							if (finalKaramPosition != -1)
							{
								delayAmount += this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
								this.bool1 = true;
								this.scheduledThreadPoolExecutor1.schedule(() -> {
									final MenuEntry entry = new MenuEntry("", "", itemID, 33, finalKaramPosition, 9764864, true);
									this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry, MenuEntrySwapHandler.enum2.INVENTORY);
								}, delayAmount, TimeUnit.MILLISECONDS);
							}

							++performedActions;
						}
					}

					if (performedActions >= actionsToPerform)
					{
						break;
					}
				}

				delayAmount = (long) ((double) delayAmount + 0.6D);
				this.scheduledThreadPoolExecutor1.schedule(() -> {
					this.bool3 = false;
					this.bool1 = false;
					this.int1 = this.client.getBoostedSkillLevel(Skill.HITPOINTS);
				}, delayAmount, TimeUnit.MILLISECONDS);
			}
		}
		catch (final Exception var8)
		{
			LOGGER.info("Failed to execute PVP action!");
			this.bool3 = false;
			this.bool1 = false;
			var8.printStackTrace();
		}
	}

	private void PQRS23TgasdUVWX114666ce13Abefgh93f9awdf()
	{
		this.bool3 = true;
		long delayAmount = 0L;
		int eatAmountThreshold = 1;
		switch (this.config.skillingMethod())
		{
			case Double:
				eatAmountThreshold = 2;
				break;
			case Triple:
				eatAmountThreshold = 3;
				break;
			default:
				break;
		}

		try
		{
			if (!this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(this.intArr1))
			{
				this.bool3 = false;
				this.bool1 = false;
				return;
			}

			final List<Item> invItems = this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(this.intArr1);
			final List<Integer> foodList = IntStream.of(this.intArr1).boxed().collect(Collectors.toList());
			int eatAmount = 0;
			Iterator<Item> var9;
			if (!this.config.eatInOrder())
			{
				for (final Item item : invItems)
				{
					if (foodList.contains(item.getId()))
					{
						if (eatAmount != 0)
						{
							delayAmount += this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
						}

						++eatAmount;
						this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(item.getId(), delayAmount);
						if (eatAmount >= eatAmountThreshold)
						{
							break;
						}
					}
				}
			}
			else
			{
				for (final Integer foodID : foodList)
				{
					if (this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(new int[]{foodID}))
					{
						if (eatAmount != 0)
						{
							delayAmount += this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
						}

						++eatAmount;
						this.AB1CaddDEdaHI12361JKLM8NO3ka5gw(foodID, delayAmount);
						if (eatAmount >= eatAmountThreshold)
						{
							break;
						}
					}
				}
			}

			delayAmount = (long) ((double) delayAmount + 0.6D);
			this.scheduledThreadPoolExecutor1.schedule(() -> {
				this.bool3 = false;
				this.bool1 = false;
				this.int1 = this.client.getBoostedSkillLevel(Skill.HITPOINTS);
			}, delayAmount, TimeUnit.MILLISECONDS);
		}
		catch (final Exception var8)
		{
			this.bool3 = false;
			this.bool1 = false;
			LOGGER.info("Failed to initiate auto-eating!");
			var8.printStackTrace();
		}

	}

	private void AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int foodID, final long delayAmount)
	{
		this.bool1 = true;
		this.scheduledThreadPoolExecutor1.schedule(() -> {
			try
			{
				if (this.client.getBoostedSkillLevel(Skill.HITPOINTS) > 0)
				{
					this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(foodID, 33, 9764864);
				}

			}
			catch (final Exception var2)
			{
				LOGGER.info("Failed to handle eat food executor!");
				var2.printStackTrace();
			}
		}, delayAmount, TimeUnit.MILLISECONDS);
	}

	@Override
	public void keyTyped(final KeyEvent keyEvent)
	{
	}

	@Override
	public void keyPressed(final KeyEvent keyEvent)
	{
		if (this.client.getGameState() == GameState.LOGGED_IN && this.config.toggleKey().matches(keyEvent) && !this.bool3 && !this.bool1)
		{
			this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf();
		}

	}

	@Override
	public void keyReleased(final KeyEvent keyEvent)
	{
		if (this.config.clearChat() && this.config.toggleKey().matches(keyEvent))
		{
			this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(keyEvent);
		}

	}
}
