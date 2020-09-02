package net.runelite.client.plugins.DeadZoneHunter;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.client.plugins.DeadZoneAPI.DeadZoneUtilities;
import net.runelite.client.plugins.DeadZoneAPI.MenuEntrySwapHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("DuplicatedCode")
public class DZHunterSalamanders implements DZHunterInterface
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DZHunterSalamanders.class);

	private final Client client;

	private final DZHunterPlugin dzHunterPlugin;

	private final DeadZoneUtilities deadZoneUtilities;

	private final DZHunterConfig config;

	private final MenuEntrySwapHandler menuEntrySwapHandler;

	private final ScheduledExecutorService scheduledExecutorService;

	private boolean bool1;
	private boolean bool2;

	private Instant instant1;
	private Instant instant2;

	private final List<DZHunterAction> dzHunterActions = new LinkedList<>();

	private final int[] youngTreeIDs = new int[]{8990, 8732, 9000, 9341};
	private final int[] gameObjectIDs = new int[]{8986, 8734, 8996, 9004};
	private final int[] activeTreeIDs = new int[]{8992, 8986, 8985, 8987, 8988, 8991, 8733, 8972, 8973, 8974, 8731, 8734, 9001, 8993, 8997, 8998, 8996, 9002, 9343, 9004, 9342, 9005, 9158, 9003};


	DZHunterSalamanders(final DZHunterPlugin plugin, final Client client, final DeadZoneUtilities utils, final DZHunterConfig config, final MenuEntrySwapHandler swapHandler, final ScheduledExecutorService executorService)
	{
		this.client = client;
		this.dzHunterPlugin = plugin;
		this.deadZoneUtilities = utils;
		this.config = config;
		this.menuEntrySwapHandler = swapHandler;
		this.scheduledExecutorService = executorService;
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3();

		if (bool2 && !dzHunterPlugin.bool1 && instant1 == null)
		{
			if (dzHunterActions.size() > 0)
			{
				cdefghi367869abcdefhJKL1234AB1Cad();
				return;
			}

			if (jkld2369IJgha561gkkbcFdaw1fa5def())
			{
				jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq();
				return;
			}

			if (asgn2kd1p2no455mnop2dqrstuvwxyz111146())
			{
				vwxyzQdw3RSTUVwxyz11114XYZ1234();
			}
		}

	}

	public final void DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		bool2 = true;
		bool1 = true;
	}

	public final void JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2()
	{
		bool1 = false;
	}

	public final void onGameObjectSpawned(final GameObjectSpawned event)
	{
	}

	public final void onGameObjectDespawned(final GameObjectDespawned event)
	{
	}

	public final void onItemSpawned(final ItemSpawned event)
	{
		if (bool1)
		{
			final TileItem item = event.getItem();
			final Tile tile = event.getTile();
			if (tile.getLocalLocation().distanceTo(Objects.requireNonNull(client.getLocalPlayer()).getLocalLocation()) <= dzHunterPlugin.int1)
			{
				final DZHunterAction action;
				if (item.getId() == 954)
				{
					action = new DZHunterAction(Instant.now(), DZHunterAction.Type.Collapsed, tile);
					action.jkld2369IJgha561gkkbcFdaw1fa5def = 954;
					dzHunterActions.add(action);
					return;
				}

				if (item.getId() == 303)
				{
					action = new DZHunterAction(Instant.now(), DZHunterAction.Type.Collapsed, tile);
					action.jkld2369IJgha561gkkbcFdaw1fa5def = 303;
					dzHunterActions.add(action);
				}
			}
		}

	}

	public final void onItemDespawned(final ItemDespawned event)
	{
		if (bool1)
		{
			final TileItem item = event.getItem();

			if (dzHunterActions.size() > 0 && (item.getId() == 954 || item.getId() == 303) && dzHunterActions.get(0).type.equals(DZHunterAction.Type.Collapsed))
			{
				LOGGER.info("Removing Action Item!");
				dzHunterActions.remove(0);
				bool2 = true;
			}
		}

	}

	public final void onAnimationChanged(final AnimationChanged event)
	{
		if (event.getActor() == client.getLocalPlayer())
		{
			assert client.getLocalPlayer() != null;

			final Player local = client.getLocalPlayer();
			if (local.getAnimation() == -1)
			{
				instant1 = Instant.now();
				if (dzHunterActions.size() > 0)
				{
					instant2 = Instant.now();
				}
			}
			else if (local.getAnimation() != -1)
			{
				instant2 = null;
				instant1 = null;
			}
		}

	}

	private boolean jkld2369IJgha561gkkbcFdaw1fa5def()
	{
		final GameObject YoungTree = deadZoneUtilities.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(youngTreeIDs);
		final List<GameObject> ActiveTrees = deadZoneUtilities.vwxyzQdw3RSTUVwxyz11114XYZ1234(activeTreeIDs);
		if (YoungTree != null)
		{
			int count = 0;

			for (final GameObject activeTree : ActiveTrees)
			{
				if (activeTree.getLocalLocation().distanceTo(Objects.requireNonNull(client.getLocalPlayer()).getLocalLocation()) <= dzHunterPlugin.int1)
				{
					++count;
				}
			}

			if (count < config.totalTraps())
			{
				return YoungTree.getLocalLocation().distanceTo(Objects.requireNonNull(client.getLocalPlayer()).getLocalLocation()) <= dzHunterPlugin.int1;
			}
		}

		return false;
	}

	private boolean asgn2kd1p2no455mnop2dqrstuvwxyz111146()
	{
		final GameObject gameObject = deadZoneUtilities.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(gameObjectIDs);
		if (gameObject != null)
		{
			return gameObject.getLocalLocation().distanceTo(Objects.requireNonNull(client.getLocalPlayer()).getLocalLocation()) <= dzHunterPlugin.int1;
		}
		else
		{
			return false;
		}
	}

	private void jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq()
	{
		instant2 = null;
		scheduledExecutorService.schedule(() -> {
			deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(3, youngTreeIDs);
			bool2 = false;
			instant2 = Instant.now();
		}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
	}

	private void cdefghi367869abcdefhJKL1234AB1Cad()
	{
		if (dzHunterActions.size() > 0)
		{
			instant2 = null;
			LOGGER.info("Handling Collapsed Trap!");
			s6641asgn2kd1dasgha1333();
		}

	}

	private void vwxyzQdw3RSTUVwxyz11114XYZ1234()
	{
		scheduledExecutorService.schedule(() -> {
			deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(3, gameObjectIDs);
			bool2 = false;
			instant2 = Instant.now();
		}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
	}

	private void s6641asgn2kd1dasgha1333()
	{
		if (dzHunterActions.get(0).itemTile.getGroundItems() != null)
		{
			scheduledExecutorService.schedule(() -> {
				final int param0 = dzHunterActions.get(0).itemTile.getLocalLocation().getSceneX();
				final int param1 = dzHunterActions.get(0).itemTile.getLocalLocation().getSceneY();
				final MenuEntry entry = new MenuEntry("", "", dzHunterActions.get(0).jkld2369IJgha561gkkbcFdaw1fa5def, 20, param0, param1, false);
				menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
				bool2 = false;
				instant2 = Instant.now();
			}, deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
		}
		else
		{
			dzHunterActions.remove(0);
		}
	}

	private void nkdaflooqwEFGHIOPQRSTUV4666ce13Ab3()
	{
		Duration retryTime;
		Duration var2;
		if (instant1 != null)
		{
			retryTime = Duration.ofMillis(deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw() + 500L);
			var2 = Duration.between(instant1, Instant.now());
			if (var2.compareTo(retryTime) >= 0)
			{
				bool2 = true;
				instant1 = null;
			}
		}

		if (instant2 != null)
		{
			retryTime = Duration.ofSeconds(DeadZoneUtilities.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(4, 5));
			var2 = Duration.between(instant2, Instant.now());
			if (var2.compareTo(retryTime) >= 0)
			{
				LOGGER.info("Detected failure, resetting!");
				bool2 = true;
				instant1 = null;
				instant2 = null;
			}
		}

	}
}
