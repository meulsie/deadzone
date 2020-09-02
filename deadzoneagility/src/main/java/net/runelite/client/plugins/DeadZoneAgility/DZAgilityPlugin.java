package net.runelite.client.plugins.DeadZoneAgility;

import com.google.inject.Provides;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.GroundObject;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuEntry;
import net.runelite.api.Skill;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.StatChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.queries.TileQuery;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.WorldService;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.DeadZoneAPI.DZWorldHopper;
import net.runelite.client.plugins.DeadZoneAPI.DeadZoneAPI;
import net.runelite.client.plugins.DeadZoneAPI.DeadZoneUtilities;
import net.runelite.client.plugins.DeadZoneAPI.MenuEntrySwapHandler;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldType;
import org.apache.commons.lang3.ArrayUtils;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"DuplicatedCode", "unused", "ConstantConditions"})
@Extension
@PluginDescriptor(
	name = "DZ Agility Helper",
	description = "Configure Agility Helper",
	tags = {"deadzone", "agility"},
	type = PluginType.SYSTEM,
	enabledByDefault = false
)
@PluginDependency(DeadZoneAPI.class)
public class DZAgilityPlugin extends Plugin implements KeyListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DZAgilityPlugin.class);

	@Inject
	private Client client;

	@Inject
	private DeadZoneAPI deadZoneAPI;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private DZAgilityOverlay dzAgilityOverlay;

	private DeadZoneUtilities deadZoneUtilities;

	@Inject
	private DZAgilityConfig dzAgilityConfig;

	@Inject
	private KeyManager keyManager;

	@Inject
	private MenuEntrySwapHandler menuEntrySwapHandler;

	@Inject
	public DZAgilityCourseManager dzAgilityCourseManager;

	@Inject
	public WorldService worldService;

	private DZWorldHopper dzWorldHopper;

	private Instant instant1;
	private Instant instant2;
	private Instant instant3;

	private boolean bool1;
	private boolean bool2;
	private boolean bool3;
	private boolean bool4;
	private boolean bool5;
	private boolean bool6;
	private boolean bool7;
	private boolean bool8;

	private int int1;
	private int int2 = -1;
	private int int3;
	private int int4;
	private int int5;
	private int int6;
	private int int7;

	private ScheduledExecutorService scheduledExecutorService;

	private LocalPoint localPoint;

	private String str1 = "";

	private Tile tile;

	private final int[] intArr = new int[]{7218, 7220};

	@Provides
	private static DZAgilityConfig AB1CaddDEdaHI12361JKLM8NO3ka5gw(final ConfigManager configManager)
	{
		return configManager.getConfig(DZAgilityConfig.class);
	}

	protected void startUp()
	{
		this.deadZoneUtilities = this.deadZoneAPI.deadZoneUtilities;
		this.overlayManager.add(this.dzAgilityOverlay);
		this.keyManager.registerKeyListener(this);
		this.scheduledExecutorService = this.deadZoneAPI.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178;
		this.dzWorldHopper = new DZWorldHopper(this.client, this.worldService);
		final String str = ColorUtil.wrapWithColorTag("| ", Color.yellow);
		this.str1 = str + ColorUtil.wrapWithColorTag("Agility Helper", Color.green) + ColorUtil.wrapWithColorTag(" | ", Color.yellow);
	}

	protected void shutDown()
	{
		this.overlayManager.remove(this.dzAgilityOverlay);
		this.keyManager.unregisterKeyListener(this);
	}

	@Subscribe
	private void onGameTick(final GameTick event)
	{
		if (this.bool5 && this.client.getLocalPlayer() != null && this.client.getGameState().equals(GameState.LOGGED_IN))
		{
			int random;
			if (this.int2 >= 0)
			{
				random = DeadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(8, 22);
				if (this.int2 + 1 >= random)
				{
					this.int2 = -1;
				}
				else
				{
					++this.int2;
				}
			}

			if (this.dzAgilityConfig.hopWorlds())
			{
				this.jkld2369IJgha561gkkbcFdaw1fa5def();
				if (this.bool1 && this.instant2 == null && !this.bool2)
				{
					if (this.client.getWidget(WidgetInfo.WORLD_SWITCHER_LIST) == null)
					{
						this.bool2 = true;
						this.scheduledExecutorService.schedule(() -> {
							this.client.openWorldHopper();
							this.bool2 = false;
						}, this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw() << 1, TimeUnit.MILLISECONDS);
						this.instant2 = Instant.now();
						return;
					}

					if (this.client.getLocalPlayer().getAnimation() == -1)
					{
						final World world = this.dzWorldHopper.AB1CaddDEdaHI12361JKLM8NO3ka5gw(WorldType.MEMBERS, this.dzAgilityConfig.worldRegion());
						if (world != null)
						{
							LOGGER.info("Hopping to World " + world.getId());
							this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", this.str1 + "Hopping to World " + world.getId(), null);
							this.dzWorldHopper.AB1CaddDEdaHI12361JKLM8NO3ka5gw(world);
							this.bool1 = false;
							this.int1 = DeadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(this.dzAgilityConfig.hopMinDelay(), this.dzAgilityConfig.hopMaxDelay());
							this.instant1 = Instant.now();
							this.instant2 = Instant.now();
							return;
						}

						LOGGER.info("Failed to find optimal world!");
					}

					return;
				}

				if (this.instant2 != null || this.bool1)
				{
					return;
				}
			}

			if (this.localPoint != null && this.int2 == -1)
			{
				random = Objects.requireNonNull(this.client.getLocalPlayer()).getAnimation();
				if (this.int3 == 4 && !this.bool2)
				{
					LOGGER.info("Detected major failure, resetting course!");
					++this.int4;
					this.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq();
					return;
				}

				if (random == -1 && this.bool7)
				{
					this.bool7 = false;
				}

				if (this.cdefghi367869abcdefhJKL1234AB1Cad() && random == -1 && !this.bool2)
				{
					++this.int5;
					final int STUVWXYZ1234AB1CaddDxyz11114666ce13A = 2;
					if (this.int5 == STUVWXYZ1234AB1CaddDxyz11114666ce13A)
					{
						LOGGER.info("Detected standing still for too long, retrying!");
						++this.int3;
						this.int5 = 0;
						if (!this.bool8)
						{
							random = DeadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(1, 100);
							if (random <= 7)
							{
								if (this.dzAgilityConfig.skillBreaks() && random <= 2)
								{
									LOGGER.info("Skilling Break Activated");
									this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", this.str1 + "Taking a break...", null);
									this.int2 = 0;
									--this.int3;
									return;
								}

								LOGGER.info("Skipping Step");
								--this.int3;
							}
							else
							{
								this.nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3();
							}
						}
					}
				}
				else if (random != -1 && random != 829 && random != 722 && random != 714)
				{
					this.int5 = 0;
					if (!this.bool7 && !this.bool8)
					{
						this.bool8 = true;
					}
				}

				if (this.client.getVarpValue(173) == 0 && !this.bool2 && this.client.getEnergy() >= 30)
				{
					this.IOPQRSTUV4abcdefgJKLM8NO3ka5gM8();
				}

				if (this.dzAgilityConfig.autoHeal() && !this.bool2 && this.client.getBoostedSkillLevel(Skill.HITPOINTS) <= this.dzAgilityConfig.hpTheshold())
				{
					this.s6641asgn2kd1dasgha1333();
				}
			}

			this.localPoint = Objects.requireNonNull(this.client.getLocalPlayer()).getLocalLocation();
		}

	}

	@Subscribe
	private void onWidgetLoaded(final WidgetLoaded event)
	{
		if (event.getGroupId() == 219 && this.bool5)
		{
			this.bool2 = true;
			this.scheduledExecutorService.schedule(() -> {
				this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw('1');
				this.bool2 = false;
			}, this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
		}

	}

	@Subscribe
	private void onStatChanged(final StatChanged event)
	{
		if (event.getSkill() == Skill.AGILITY && this.bool5 && this.bool6 && event.getXp() != this.int7)
		{
			LOGGER.info("Detected XP Drop, advancing step!");
			this.int7 = this.client.getSkillExperience(Skill.AGILITY);
			this.bool6 = false;
			this.int3 = 0;
			this.int5 = 0;
			this.int6 = 0;
			this.bool7 = true;
			this.bool8 = false;
			this.dzAgilityCourseManager.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
			final int random = DeadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(1, 100);
			if (this.dzAgilityCourseManager.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2() != 0 && Objects.requireNonNull(this.client.getLocalPlayer()).getAnimation() == -1 && !this.bool2)
			{
				if (random <= 7)
				{
					if (this.dzAgilityConfig.skillBreaks() && random <= 2)
					{
						LOGGER.info("Skilling Break Activated");
						this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", this.str1 + "Taking a break...", null);
						this.int2 = 0;
						return;
					}

					LOGGER.info("Skipping Step");
					return;
				}

				this.nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3();
				return;
			}

			if (this.dzAgilityCourseManager.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2() == 0)
			{
				if (!this.asgn2kd1p2no455mnop2dqrstuvwxyz111146())
				{
					LOGGER.info("Timeout limit reached! Stopping agility helper...");
					this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", this.str1 + "Timeout limit reached, shutting down!", null);
					this.AB35raDWsFGHda212365IJKL12tfa1MNO();
					return;
				}

				if (this.dzAgilityConfig.hopWorlds() && this.instant1 == null)
				{
					LOGGER.info("World Hop Available!");
					this.bool1 = true;
					return;
				}

				if (this.dzAgilityConfig.seersTP() && this.dzAgilityConfig.agilityMethod() == DZAgilityCourse.Seers)
				{
					this.vwxyzQdw3RSTUVwxyz11114XYZ1234();
					return;
				}

				if (Objects.requireNonNull(this.client.getLocalPlayer()).getAnimation() == -1 && !this.bool2)
				{
					this.nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3();
				}
			}
		}

	}

	private void jkld2369IJgha561gkkbcFdaw1fa5def()
	{
		Duration retryTime;
		Duration var2;
		if (this.instant1 != null)
		{
			retryTime = Duration.ofMinutes(this.int1);
			var2 = Duration.between(this.instant1, Instant.now());
			if (var2.compareTo(retryTime) >= 0)
			{
				this.instant1 = null;
			}
		}

		if (this.instant2 != null)
		{
			retryTime = Duration.ofMillis(DeadZoneUtilities.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(3000, 4000));
			var2 = Duration.between(this.instant2, Instant.now());
			if (var2.compareTo(retryTime) >= 0)
			{
				this.instant2 = null;
			}
		}

	}

	private void PQRS23TgasdUVWX114666ce13Abefgh93f9awdf()
	{
		this.instant3 = Instant.now();
	}

	private boolean asgn2kd1p2no455mnop2dqrstuvwxyz111146()
	{
		if (this.instant3 != null)
		{
			final Duration timeout = Duration.ofMinutes(this.dzAgilityConfig.timeout());
			final Duration var2 = Duration.between(this.instant3, Instant.now());
			return var2.compareTo(timeout) < 0;
		}
		else
		{
			return false;
		}
	}

	final long AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		if (this.instant3 != null)
		{
			final Duration between = Duration.between(this.instant3, Instant.now());
			return (long) this.dzAgilityConfig.timeout() - between.toMinutes();
		}
		else
		{
			return this.dzAgilityConfig.timeout();
		}
	}

	final boolean DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		return this.bool5;
	}

	@Subscribe
	private void onChatMessage(final ChatMessage event)
	{
		if (event.getMessage().equals("I can't reach that!"))
		{
			this.int6 = 2;
		}

	}

	@Subscribe
	private void onItemSpawned(final ItemSpawned itemSpawned)
	{
		final TileItem item = itemSpawned.getItem();
		final Tile tile = itemSpawned.getTile();
		if (item.getId() == 11849)
		{
			this.tile = tile;
			this.bool4 = true;
		}

	}

	@Subscribe
	private void onItemDespawned(final ItemDespawned itemDespawned)
	{
		final TileItem itemDespawned1 = itemDespawned.getItem();
		if (itemDespawned1.getId() == 11849)
		{
			this.bool4 = false;
			this.nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3();
		}

	}

	private void jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq()
	{
		if (this.asgn2kd1p2no455mnop2dqrstuvwxyz111146() && this.int4 < 3)
		{
			this.int5 = 0;
			this.int3 = 0;
			this.bool7 = true;
			this.bool8 = false;
			this.dzAgilityCourseManager.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178();
			this.nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3();
		}
		else
		{
			LOGGER.info("Detected too many failures, shutting down!");
			this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", this.str1 + "Detected too many failures, shutting down!", null);
			this.AB35raDWsFGHda212365IJKL12tfa1MNO();
		}
	}

	private boolean cdefghi367869abcdefhJKL1234AB1Cad()
	{
		return this.localPoint.getX() == Objects.requireNonNull(this.client.getLocalPlayer()).getLocalLocation().getX() && this.localPoint.getY() == this.client.getLocalPlayer().getLocalLocation().getY();
	}

	@Subscribe
	private void onHitsplatApplied(final HitsplatApplied event)
	{
		if (this.bool5 && event.getHitsplat().isMine())
		{
			LOGGER.info("Detected failed obstacle, resetting course!");
			this.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq();
		}

	}

	@Subscribe
	private void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN && this.bool5)
		{
			this.AB35raDWsFGHda212365IJKL12tfa1MNO();
		}

	}

	private void vwxyzQdw3RSTUVwxyz11114XYZ1234()
	{
		this.bool2 = true;
		this.scheduledExecutorService.submit(() -> {
			final MenuEntry entry = new MenuEntry("", "", 2, 57, -1, 14286879, false);
			this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);

			try
			{
				Thread.sleep(3000L);
			}
			catch (final Exception var2)
			{
				var2.printStackTrace();
			}

			this.bool2 = false;
			this.nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3();
		});
	}

	private void s6641asgn2kd1dasgha1333()
	{
		try
		{
			final ItemContainer container = this.client.getItemContainer(InventoryID.INVENTORY);
			if (container != null)
			{
				final Item[] items = container.getItems();
				final List<Integer> healItems = Arrays.asList(ArrayUtils.toObject(DeadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(this.dzAgilityConfig.foodID())));
				long delay = this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw();

				for (final Item item : items)
				{
					if (healItems.contains(item.getId()))
					{
						this.bool2 = true;
						this.scheduledExecutorService.schedule(() -> {
							this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(item.getId(), 33, 9764864);
						}, delay, TimeUnit.MILLISECONDS);
						delay += this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
						break;
					}
				}

				this.scheduledExecutorService.schedule(() -> {
					this.bool8 = false;
					this.bool2 = false;
				}, delay, TimeUnit.MILLISECONDS);
			}

		}
		catch (final Exception var8)
		{
			LOGGER.info("Failed to heal myself!");
			this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", this.str1 + "Failed to heal myself!", null);
			var8.printStackTrace();
		}
	}

	private void nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3()
	{
		if (!this.bool2)
		{
			try
			{
				if (this.bool4 && (this.dzAgilityConfig.pickupMarks() || this.dzAgilityConfig.delayedPickup()) && this.int6 < 2)
				{
					final Tile playerTile = (new TileQuery()).atWorldLocation(Objects.requireNonNull(this.client.getLocalPlayer()).getWorldLocation()).result(this.client).first();
					if (playerTile != null && this.tile.getWorldLocation().isInScene(this.client) && (this.tile.getLocalLocation().distanceTo(Objects.requireNonNull(this.client.getLocalPlayer()).getLocalLocation()) <= this.dzAgilityConfig.agilityMethod().getMarkPickupDistance() || this.dzAgilityConfig.agilityMethod().isMarkSightCheck() && this.tile.hasLineOfSightTo(playerTile)) && (this.dzAgilityConfig.delayedPickup() && this.AB1CaddDEdaHI12361JKLM8NO3ka5gw() < 5L || !this.dzAgilityConfig.delayedPickup()))
					{
						this.bool2 = true;
						this.scheduledExecutorService.schedule(this::JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2, this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
						return;
					}
				}
			}
			catch (final Exception var5)
			{
				LOGGER.info("Failed to pickup mark!");
				var5.printStackTrace();
			}

			int delay = 0;
			if (this.dzAgilityConfig.magicImbue() && !this.bool6)
			{
				delay = (int) (this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw());
				this.bool2 = true;
				this.scheduledExecutorService.schedule(() -> {
					final MenuEntry entry = new MenuEntry("", "", 1, 57, -1, 14286972, false);
					this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
					this.bool2 = false;
				}, delay, TimeUnit.MILLISECONDS);
			}

			try
			{
				if (this.dzAgilityConfig.summerPie() && this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(this.intArr) && this.client.getBoostedSkillLevel(Skill.AGILITY) < this.dzAgilityConfig.agilityMethod().getAgilityLevel())
				{
					delay = (int) ((long) delay + this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw());
					this.bool2 = true;
					this.scheduledExecutorService.schedule(() -> {
						this.FGw3gHIJdaw1faKLM8NO3ka5gwPQRS23();
						this.bool2 = false;
					}, delay, TimeUnit.MILLISECONDS);
				}

				if (this.dzAgilityConfig.restoreStamina() && this.client.getEnergy() <= this.dzAgilityConfig.restoreStaminaThreshold() && this.bool3)
				{
					delay = (int) ((long) delay + this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw());
					this.bool2 = true;
					this.scheduledExecutorService.schedule(() -> {
						this.stuvwxdwyz1111EFda123ghaswGHIOP();
						this.bool2 = false;
					}, delay, TimeUnit.MILLISECONDS);
				}
			}
			catch (final Exception var3)
			{
				LOGGER.info("Failed to restore stamina or use summer pies!");
				var3.printStackTrace();
			}

			try
			{
				final DeadZoneUtilities.enum3 type = this.deadZoneUtilities.s6641asgn2kd1dasgha1333(this.dzAgilityCourseManager.jkld2369IJgha561gkkbcFdaw1fa5def());
				if (type != DeadZoneUtilities.enum3.NULL)
				{
					delay = (int) ((long) delay + this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw());
					switch (Objects.requireNonNull(type))
					{
						case DECOROBJECT:
							final DecorativeObject decorObject = this.deadZoneUtilities.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq(this.dzAgilityCourseManager.jkld2369IJgha561gkkbcFdaw1fa5def());

							assert decorObject != null;

							this.bool2 = true;
							this.scheduledExecutorService.schedule(() -> {
								final int param0 = decorObject.getLocalLocation().getSceneX();
								final int param1 = decorObject.getLocalLocation().getSceneY();
								final MenuEntry entry = new MenuEntry("", "", this.dzAgilityCourseManager.jkld2369IJgha561gkkbcFdaw1fa5def(), 3, param0, param1, false);
								this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
								this.bool6 = true;
								this.bool2 = false;
							}, delay, TimeUnit.MILLISECONDS);
							return;
						case GAMEOBJECT:
							final GameObject gameObject = this.deadZoneUtilities.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(this.dzAgilityCourseManager.jkld2369IJgha561gkkbcFdaw1fa5def());

							assert gameObject != null;

							this.bool2 = true;
							this.scheduledExecutorService.schedule(() -> {
								final int param0 = gameObject.getSceneMinLocation().getX();
								final int param1 = gameObject.getSceneMinLocation().getY();
								final MenuEntry entry = new MenuEntry("", "", this.dzAgilityCourseManager.jkld2369IJgha561gkkbcFdaw1fa5def(), 3, param0, param1, false);
								this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
								this.bool6 = true;
								this.bool2 = false;
							}, delay, TimeUnit.MILLISECONDS);
							return;
						case GROUNDOBJECT:
							final GroundObject groundObject = this.deadZoneUtilities.cdefghi367869abcdefhJKL1234AB1Cad(this.dzAgilityCourseManager.jkld2369IJgha561gkkbcFdaw1fa5def());

							assert groundObject != null;

							this.bool2 = true;
							this.scheduledExecutorService.schedule(() -> {
								final int param0 = groundObject.getLocalLocation().getSceneX();
								final int param1 = groundObject.getLocalLocation().getSceneY();
								final MenuEntry entry = new MenuEntry("", "", this.dzAgilityCourseManager.jkld2369IJgha561gkkbcFdaw1fa5def(), 3, param0, param1, false);
								this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
								this.bool6 = true;
								this.bool2 = false;
							}, delay, TimeUnit.MILLISECONDS);
						default:
							break;
					}
				}

			}
			catch (final Exception var4)
			{
				LOGGER.info("Failed to handle current step!");
				this.bool2 = false;
				var4.printStackTrace();
			}
		}

	}

	private void JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2()
	{
		LOGGER.info("Picking up mark of grace...");
		final int param0 = this.tile.getLocalLocation().getSceneX();
		final int param1 = this.tile.getLocalLocation().getSceneY();
		final MenuEntry entry = new MenuEntry("", "", 11849, 20, param0, param1, false);
		this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
		++this.int6;
		this.bool2 = false;
	}

	private void stuvwxdwyz1111EFda123ghaswGHIOP()
	{
		final Set<Integer> itemIDs = DZAgilityStamina.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178();
		this.bool3 = false;

		for (final int id : itemIDs)
		{
			if (this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(id, 33, 9764864))
			{
				try
				{
					Thread.sleep(this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw());
				}
				catch (final InterruptedException var3)
				{
					var3.printStackTrace();
				}
				break;
			}
		}

		if (this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(DZAgilityStamina.STAMINA_POTION.AB1CaddDEdaHI12361JKLM8NO3ka5gw()) || this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(DZAgilityStamina.SUPER_ENERGY.AB1CaddDEdaHI12361JKLM8NO3ka5gw()))
		{
			this.bool3 = true;
		}

	}

	private void FGw3gHIJdaw1faKLM8NO3ka5gwPQRS23()
	{
		if (this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(new int[]{7220}))
		{
			this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(7220, 33, 9764864);

			try
			{
				Thread.sleep(this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw());
			}
			catch (final InterruptedException var2)
			{
				var2.printStackTrace();
			}
		}
		else
		{
			if (this.deadZoneUtilities.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(new int[]{7218}))
			{
				this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(7218, 33, 9764864);

				try
				{
					Thread.sleep(this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw());
				}
				catch (final InterruptedException var3)
				{
					var3.printStackTrace();
				}
			}

		}
	}

	private void IOPQRSTUV4abcdefgJKLM8NO3ka5gM8()
	{
		this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(new MenuEntry("Toggle Run", "", 1, 57, -1, 10485782, false));
	}

	private void VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3()
	{
		if (this.scheduledExecutorService != null)
		{
			this.dzAgilityCourseManager.AB1CaddDEdaHI12361JKLM8NO3ka5gw(this.dzAgilityConfig.agilityMethod());
			this.bool3 = true;
			this.bool6 = true;
			this.bool2 = false;
			this.int7 = this.client.getSkillExperience(Skill.AGILITY);
			this.int2 = -1;
			this.int4 = 0;
			this.int6 = 0;
			this.int3 = 0;
			this.int5 = 0;
			this.bool7 = true;
			this.bool8 = false;
			if (this.dzAgilityConfig.hopWorlds())
			{
				this.bool1 = false;
				this.int1 = DeadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(this.dzAgilityConfig.hopMinDelay(), this.dzAgilityConfig.hopMaxDelay());
				this.instant1 = Instant.now();
			}

			this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf();
			this.bool5 = true;
			this.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq();
		}

	}

	private void AB35raDWsFGHda212365IJKL12tfa1MNO()
	{
		this.bool5 = false;
		this.instant3 = null;
		this.dzAgilityCourseManager.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178();
	}

	public void keyTyped(final KeyEvent keyEvent)
	{
	}

	public void keyPressed(final KeyEvent keyEvent)
	{
		if (this.client.getGameState() == GameState.LOGGED_IN && this.dzAgilityConfig.toggleKey().matches(keyEvent) && this.client.getCanvas().hasFocus())
		{
			if (!this.bool5)
			{
				this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3();
				return;
			}

			this.AB35raDWsFGHda212365IJKL12tfa1MNO();
		}

	}

	public void keyReleased(final KeyEvent keyEvent)
	{
	}
}
