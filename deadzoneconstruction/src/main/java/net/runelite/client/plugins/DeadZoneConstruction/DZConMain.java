package net.runelite.client.plugins.DeadZoneConstruction;

import java.time.Duration;
import java.time.Instant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.queries.TileQuery;
import net.runelite.client.plugins.DeadZoneAPI.DZStepManager;
import net.runelite.client.plugins.DeadZoneAPI.DeadZoneUtilities;
import net.runelite.client.plugins.DeadZoneAPI.MenuEntrySwapHandler;

public class DZConMain implements DZConInterface
{
	@Inject
	private final Client client;

	private final DZConPlugin plugin;

	private final DeadZoneUtilities utils;

	private final DZConConfig config;

	private final MenuEntrySwapHandler swapHandler;

	private final ScheduledExecutorService executorService;

	private DZStepManager stepManager;

	private boolean notIdle;

	private final List<Integer> requiredItems = new LinkedList<>();

	private int[] buildObjectIDs;
	private int[] removeObjectIDs;

	private Instant instant1;
	private Instant instant2;

	DZConMain(final DZConPlugin plugin, final Client client, final DeadZoneUtilities utils, final DZConConfig config, final MenuEntrySwapHandler swapHandler, final ScheduledExecutorService executorService)
	{
		this.client = client;
		this.plugin = plugin;
		this.utils = utils;
		this.config = config;
		this.swapHandler = swapHandler;
		this.executorService = executorService;
	}

	@Override
	public final void activate()
	{
		stepManager = new DZStepManager(4);

		requiredItems.add(config.skillingMethod().getRequiredItem());

		buildObjectIDs = config.skillingMethod().getBuildObjectIDs();

		removeObjectIDs = config.skillingMethod().getRemoveObjectIDs();

		notIdle = false;

		plugin.isActive = true;

		if (butlerPresent())
		{
			talkToButler();
		}

	}

	@Override
	public final void onGameTick()
	{
		s6641asgn2kd1dasgha1333();

		if (stepManager != null)
		{
			switch (stepManager.jkld2369IJgha561gkkbcFdaw1fa5def())
			{
				case 0:
					if (butlerPresent())
					{
						talkToButler();
						return;
					}
					break;
				case 1:
					if (!notIdle)
					{
						if (AB1CaddDEdaHI12361JKLM8NO3ka5gw(removeObjectIDs) && instant2 == null && !plugin.scheduled)
						{
							removeObject();
							return;
						}

						if (AB1CaddDEdaHI12361JKLM8NO3ka5gw(buildObjectIDs) && instant1 == null && jkld2369IJgha561gkkbcFdaw1fa5def() && !plugin.scheduled)
						{
							buildObject();
							return;
						}
					}

					if (!jkld2369IJgha561gkkbcFdaw1fa5def())
					{
						stepManager.AB1CaddDEdaHI12361JKLM8NO3ka5gw(0);
					}
			}
		}

	}

	@Override
	public final void onGameObjectSpawned(final GameObjectSpawned gameObjectSpawned)
	{
		int[] var2;
		int var3;
		int var4;
		int id;
		if (jkld2369IJgha561gkkbcFdaw1fa5def())
		{
			var3 = (var2 = buildObjectIDs).length;

			for (var4 = 0; var4 < var3; ++var4)
			{
				id = var2[var4];
				if (gameObjectSpawned.getGameObject().getId() == id)
				{
					buildObject();
					return;
				}
			}
		}

		var3 = (var2 = removeObjectIDs).length;

		for (var4 = 0; var4 < var3; ++var4)
		{
			id = var2[var4];
			if (gameObjectSpawned.getGameObject().getId() == id)
			{
				removeObject();
			}
		}

	}

	@Override
	public final void onWallObjectSpawned(final WallObjectSpawned wallObjectSpawned)
	{
		int[] var2;
		int var3;
		int var4;
		int id;
		if (jkld2369IJgha561gkkbcFdaw1fa5def())
		{
			var3 = (var2 = buildObjectIDs).length;

			for (var4 = 0; var4 < var3; ++var4)
			{
				id = var2[var4];
				if (wallObjectSpawned.getWallObject().getId() == id)
				{
					buildObject();
					return;
				}
			}
		}

		var3 = (var2 = removeObjectIDs).length;

		for (var4 = 0; var4 < var3; ++var4)
		{
			id = var2[var4];
			if (wallObjectSpawned.getWallObject().getId() == id)
			{
				removeObject();
			}
		}

	}

	@Override
	public final void onDecorativeObectSpawned(final DecorativeObjectSpawned decorativeObjectSpawned)
	{
		int[] var2;
		int var3;
		int var4;
		int id;
		if (jkld2369IJgha561gkkbcFdaw1fa5def())
		{
			var3 = (var2 = buildObjectIDs).length;

			for (var4 = 0; var4 < var3; ++var4)
			{
				id = var2[var4];
				if (decorativeObjectSpawned.getDecorativeObject().getId() == id)
				{
					buildObject();
					return;
				}
			}
		}

		var3 = (var2 = removeObjectIDs).length;

		for (var4 = 0; var4 < var3; ++var4)
		{
			id = var2[var4];
			if (decorativeObjectSpawned.getDecorativeObject().getId() == id)
			{
				removeObject();
			}
		}

	}

	@Override
	public final void onWidgetLoaded(final WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == 458)
		{
			utils.AB1CaddDEdaHI12361JKLM8NO3ka5gw(config.skillingMethod().getBuildKey());
		}
		else
		{
			if (widgetLoaded.getGroupId() == 219)
			{
				utils.AB1CaddDEdaHI12361JKLM8NO3ka5gw('1');
				if (stepManager.jkld2369IJgha561gkkbcFdaw1fa5def() == 0)
				{
					stepManager.AB1CaddDEdaHI12361JKLM8NO3ka5gw();
				}

				if (AB1CaddDEdaHI12361JKLM8NO3ka5gw(removeObjectIDs) && !plugin.scheduled)
				{
					removeObject();
					return;
				}

				if (AB1CaddDEdaHI12361JKLM8NO3ka5gw(buildObjectIDs) && jkld2369IJgha561gkkbcFdaw1fa5def() && !plugin.scheduled)
				{
					buildObject();
					return;
				}

				if (!jkld2369IJgha561gkkbcFdaw1fa5def())
				{
					stepManager.AB1CaddDEdaHI12361JKLM8NO3ka5gw(0);

					if (butlerPresent())
					{
						talkToButler();
					}
				}
			}
			else if (widgetLoaded.getGroupId() == 231)
			{
				utils.AB1CaddDEdaHI12361JKLM8NO3ka5gw('1');
				stepManager.JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2();
				if (butlerPresent())
				{
					talkToButler();
				}
			}
			else if (widgetLoaded.getGroupId() == 233 && AB1CaddDEdaHI12361JKLM8NO3ka5gw(removeObjectIDs) && !plugin.scheduled)
			{
				removeObject();
			}

		}
	}

	@Override
	public final void onAnimationedChanged(final AnimationChanged animationChanged)
	{
		if (animationChanged.getActor().equals(client.getLocalPlayer()))
		{
			notIdle = client.getLocalPlayer().getAnimation() != -1;
		}
	}

	private boolean jkld2369IJgha561gkkbcFdaw1fa5def()
	{
		final Iterator<Integer> var1 = requiredItems.iterator();

		int id;

		do
		{
			if (!var1.hasNext())
			{
				return true;
			}

			id = var1.next();
		} while (utils.DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178(new int[]{id}));

		return false;
	}

	private boolean butlerPresent()
	{
		final NPC butler = utils.jkld2369IJgha561gkkbcFdaw1fa5def(229);

		if (butler != null)
		{
			final Tile butlerTile = (new TileQuery()).atWorldLocation(butler.getWorldLocation()).result(client).first();
			final Tile playerTile = (new TileQuery()).atWorldLocation(Objects.requireNonNull(client.getLocalPlayer()).getWorldLocation()).result(client).first();

			if (butlerTile != null && playerTile != null)
			{
				return butlerTile.hasLineOfSightTo(playerTile) && butler.getLocalLocation().distanceTo(client.getLocalPlayer().getLocalLocation()) <= 140;
			}
		}

		return false;
	}

	private boolean AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int[] ids)
	{
		switch (config.skillingMethod().getType())
		{
			case GameObject:
				if (utils.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(ids) != null)
				{
					return true;
				}
				break;
			case WallObject:
				if (utils.asgn2kd1p2no455mnop2dqrstuvwxyz111146(ids) != null)
				{
					return true;
				}
				break;
			case Decoration:
				if (utils.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq(ids) != null)
				{
					return true;
				}
		}

		return false;
	}

	private void talkToButler()
	{
		final NPC butler = utils.jkld2369IJgha561gkkbcFdaw1fa5def(229);

		if (butler != null)
		{
			plugin.scheduled = true;

			executorService.schedule(() -> {
				final MenuEntry entry = new MenuEntry("", "", butler.getIndex(), 9, 0, 0, true);
				swapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
				plugin.scheduled = false;
			}, utils.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
		}

	}

	private void buildObject()
	{
		switch (config.skillingMethod().getType())
		{
			case GameObject:
				final GameObject gameObject = utils.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(buildObjectIDs);

				if (gameObject != null)
				{
					instant1 = Instant.now();
					plugin.scheduled = true;
					executorService.schedule(() -> {
						final int param0 = gameObject.getSceneMinLocation().getX();
						final int param1 = gameObject.getSceneMinLocation().getY();
						final MenuEntry entry = new MenuEntry("", "", gameObject.getId(), 1001, param0, param1, true);
						swapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
						plugin.scheduled = false;
					}, utils.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
					return;
				}
				break;
			case WallObject:
				final WallObject wall = utils.asgn2kd1p2no455mnop2dqrstuvwxyz111146(buildObjectIDs);

				if (wall != null)
				{
					instant1 = Instant.now();

					plugin.scheduled = true;

					executorService.schedule(() -> {
						final int param0 = wall.getLocalLocation().getSceneX();
						final int param1 = wall.getLocalLocation().getSceneY();
						final MenuEntry entry = new MenuEntry("", "", wall.getId(), 1001, param0, param1, true);
						swapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
						plugin.scheduled = false;
					}, utils.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);

					return;
				}
				break;
			case Decoration:
				final DecorativeObject decor = utils.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq(buildObjectIDs);

				if (decor != null)
				{
					instant1 = Instant.now();

					plugin.scheduled = true;

					executorService.schedule(() -> {
						final int param0 = decor.getLocalLocation().getSceneX();
						final int param1 = decor.getLocalLocation().getSceneY();
						final MenuEntry entry = new MenuEntry("", "", decor.getId(), 1001, param0, param1, true);
						swapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
						plugin.scheduled = false;
					}, utils.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
				}
				break;
			default:
				break;
		}

	}

	private void removeObject()
	{
		switch (config.skillingMethod().getType())
		{
			case GameObject:
				final GameObject gameObject = utils.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(removeObjectIDs);

				if (gameObject != null)
				{
					instant2 = Instant.now();

					plugin.scheduled = true;

					executorService.schedule(() -> {
						final int param0 = gameObject.getSceneMinLocation().getX();
						final int param1 = gameObject.getSceneMinLocation().getY();
						final MenuEntry entry = new MenuEntry("", "", gameObject.getId(), 1001, param0, param1, true);
						swapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
						plugin.scheduled = false;
					}, utils.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);

					return;
				}
				break;
			case WallObject:
				final WallObject wall = utils.asgn2kd1p2no455mnop2dqrstuvwxyz111146(removeObjectIDs);

				if (wall != null)
				{
					instant2 = Instant.now();
					plugin.scheduled = true;
					executorService.schedule(() -> {
						final int param0 = wall.getLocalLocation().getSceneX();
						final int param1 = wall.getLocalLocation().getSceneY();
						final MenuEntry entry = new MenuEntry("", "", wall.getId(), 1001, param0, param1, true);
						swapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
						plugin.scheduled = false;
					}, utils.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
					return;
				}
				break;
			case Decoration:
				final DecorativeObject decor = utils.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq(removeObjectIDs);

				if (decor != null)
				{
					instant2 = Instant.now();
					plugin.scheduled = true;
					executorService.schedule(() -> {
						final int param0 = decor.getLocalLocation().getSceneX();
						final int param1 = decor.getLocalLocation().getSceneY();
						final MenuEntry entry = new MenuEntry("", "", decor.getId(), 1001, param0, param1, true);
						swapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
						plugin.scheduled = false;
					}, utils.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
				}
		}

	}

	private void s6641asgn2kd1dasgha1333()
	{
		Duration retryTime;

		if (instant1 != null)
		{
			retryTime = Duration.ofMillis(1500L);

			if (Duration.between(instant1, Instant.now()).compareTo(retryTime) >= 0)
			{
				instant1 = null;
			}
		}

		if (instant2 != null)
		{
			retryTime = Duration.ofMillis(1500L);

			if (Duration.between(instant2, Instant.now()).compareTo(retryTime) >= 0)
			{
				instant2 = null;
			}
		}

	}
}
