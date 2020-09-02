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

public class DZHunterChins implements DZHunterInterface
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DZHunterChins.class);

	private final Client client;

	private final DZHunterPlugin dzHunterPlugin;

	private final DeadZoneUtilities deadZoneUtilities;

	private final MenuEntrySwapHandler menuEntrySwapHandler;

	private final ScheduledExecutorService scheduledExecutorService;

	private boolean bool1;
	private boolean bool2;

	private Instant instant1;
	private Instant instant2;

	private final int[] gameObjectIDs = new int[]{9383, 721};

	private final List<DZHunterAction> VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3 = new LinkedList<>();

	DZHunterChins(final DZHunterPlugin plugin, final Client client, final DeadZoneUtilities utils, final MenuEntrySwapHandler swapHandler, final ScheduledExecutorService executorService)
	{
		this.dzHunterPlugin = plugin;
		this.client = client;
		this.deadZoneUtilities = utils;
		this.menuEntrySwapHandler = swapHandler;
		this.scheduledExecutorService = executorService;
	}

	public final void AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		this.s6641asgn2kd1dasgha1333();
		if (this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.size() > 0 && this.bool2 && !this.dzHunterPlugin.bool1 && this.instant1 == null)
		{
			this.asgn2kd1p2no455mnop2dqrstuvwxyz111146();
		}
		else
		{
			if ((this.jkld2369IJgha561gkkbcFdaw1fa5def() || this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf()) && this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.size() == 0)
			{
				if (this.jkld2369IJgha561gkkbcFdaw1fa5def())
				{
					LOGGER.info("Adding none actioned Successful Trap!");
					this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.add(new DZHunterAction(Instant.now(), DZHunterAction.Type.Success, null));
				}

				if (this.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf())
				{
					LOGGER.info("Adding none actioned Failed Trap!");
					this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.add(new DZHunterAction(Instant.now(), DZHunterAction.Type.Failed, null));
				}
			}

		}
	}

	public final void DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.clear();
		this.bool2 = true;
		this.instant2 = null;
		this.instant1 = null;
		this.bool1 = true;
	}

	public final void JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2()
	{
		this.bool1 = false;
	}

	@Override
	public final void onGameObjectSpawned(final GameObjectSpawned event)
	{
		if (this.bool1 && event.getGameObject().getLocalLocation().distanceTo(Objects.requireNonNull(this.client.getLocalPlayer()).getLocalLocation()) <= this.dzHunterPlugin.int1)
		{
			if (event.getGameObject().getId() == 9383 || event.getGameObject().getId() == 721)
			{
				LOGGER.info(String.valueOf(event.getGameObject().getWorldLocation()));
				this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.add(new DZHunterAction(Instant.now(), DZHunterAction.Type.Success, null));
				return;
			}

			if (event.getGameObject().getId() == 9385)
			{
				this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.add(new DZHunterAction(Instant.now(), DZHunterAction.Type.Failed, null));
			}
		}

	}

	@Override
	public final void onGameObjectDespawned(final GameObjectDespawned event)
	{
		if (this.bool1
			&& event.getGameObject().getLocalLocation().distanceTo(Objects.requireNonNull(this.client.getLocalPlayer()).getLocalLocation()) <= this.dzHunterPlugin.int1
			&& (event.getGameObject().getId() == 9383
			|| event.getGameObject().getId() == 721
			|| event.getGameObject().getId() == 9385
			&& this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.size() > 0)
			&& (this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.get(0).type.equals(DZHunterAction.Type.Success)
			|| this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.get(0).type.equals(DZHunterAction.Type.Failed)))
		{
			this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.remove(0);
		}

	}

	@Override
	public final void onItemSpawned(final ItemSpawned event)
	{
		if (this.bool1)
		{
			final TileItem item = event.getItem();
			final Tile tile = event.getTile();
			if (item.getId() == 10008 && tile.getLocalLocation().distanceTo(Objects.requireNonNull(this.client.getLocalPlayer()).getLocalLocation()) <= this.dzHunterPlugin.int1)
			{
				this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.add(new DZHunterAction(Instant.now(), DZHunterAction.Type.Collapsed, tile));
			}
		}

	}

	@Override
	public final void onItemDespawned(final ItemDespawned event)
	{
		if (this.bool1)
		{
			final TileItem item = event.getItem();

			if (this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.size() > 0 && item.getId() == 10008 && this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.get(0).type.equals(DZHunterAction.Type.Collapsed))
			{
				LOGGER.info("Removing Action Item!");

				for (int i = this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.size() - 1; i >= 0; --i)
				{
					if (this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.get(i).itemTile != null && this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.get(i).itemTile.getGroundItems() == null)
					{
						this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.remove(i);
					}
				}
			}
		}

	}

	@Override
	public final void onAnimationChanged(final AnimationChanged event)
	{
		if (event.getActor() == this.client.getLocalPlayer())
		{
			assert this.client.getLocalPlayer() != null;

			final Player local = this.client.getLocalPlayer();
			if (local.getAnimation() == -1)
			{
				this.instant1 = Instant.now();
				if (this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.size() > 0)
				{
					this.instant2 = Instant.now();
				}
			}
			else if (local.getAnimation() != -1)
			{
				this.instant2 = null;
				this.instant1 = null;
			}
		}
	}

	private boolean jkld2369IJgha561gkkbcFdaw1fa5def()
	{
		final GameObject object = this.deadZoneUtilities.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(this.gameObjectIDs);
		if (object != null)
		{
			return object.getLocalLocation().distanceTo(Objects.requireNonNull(this.client.getLocalPlayer()).getLocalLocation()) <= this.dzHunterPlugin.int1;
		}
		else
		{
			return false;
		}
	}

	private boolean PQRS23TgasdUVWX114666ce13Abefgh93f9awdf()
	{
		final GameObject object = this.deadZoneUtilities.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(9385);
		if (object != null)
		{
			return object.getLocalLocation().distanceTo(Objects.requireNonNull(this.client.getLocalPlayer()).getLocalLocation()) <= this.dzHunterPlugin.int1;
		}
		else
		{
			return false;
		}
	}

	private void asgn2kd1p2no455mnop2dqrstuvwxyz111146()
	{
		if (this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.size() > 0)
		{
			this.instant2 = null;
			switch (this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.get(0).type)
			{
				case Success:
					this.jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq();
					return;
				case Failed:
					this.cdefghi367869abcdefhJKL1234AB1Cad();
					return;
				case Collapsed:
					this.vwxyzQdw3RSTUVwxyz11114XYZ1234();
			}
		}

	}

	private void jkl2dawd345O3kd5a5gM8NO3ka5gwP5mnop2dq()
	{
		this.scheduledExecutorService.schedule(() -> {
			LOGGER.info("Handling Successful Trap!");
			final GameObject object = this.deadZoneUtilities.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(this.gameObjectIDs);
			if (object != null)
			{
				final int param0 = object.getSceneMinLocation().getX();
				final int param1 = object.getSceneMinLocation().getY();
				final MenuEntry entry = new MenuEntry("", "", object.getId(), 4, param0, param1, false);
				this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
			}
			else
			{
				LOGGER.info("Removing invalid successful trap!");
				this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.remove(0);
			}

			this.bool2 = false;
			this.instant2 = Instant.now();
		}, this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
	}

	private void cdefghi367869abcdefhJKL1234AB1Cad()
	{
		this.scheduledExecutorService.schedule(() -> {
			LOGGER.info("Handling Failed Trap!");
			final GameObject object = this.deadZoneUtilities.PQRS23TgasdUVWX114666ce13Abefgh93f9awdf(9385);
			if (object != null)
			{
				final int param0 = object.getSceneMinLocation().getX();
				final int param1 = object.getSceneMinLocation().getY();
				final MenuEntry entry = new MenuEntry("", "", object.getId(), 4, param0, param1, false);
				this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
			}
			else
			{
				LOGGER.info("Removing invalid failed trap!");
				this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.remove(0);
			}

			this.bool2 = false;
			this.instant2 = Instant.now();
		}, this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
	}

	private void vwxyzQdw3RSTUVwxyz11114XYZ1234()
	{
		if (this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.get(0).itemTile.getGroundItems() != null)
		{
			this.scheduledExecutorService.schedule(() -> {
				LOGGER.info("Handling Collapsed Trap!");
				final int param0 = this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.get(0).itemTile.getLocalLocation().getSceneX();
				final int param1 = this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.get(0).itemTile.getLocalLocation().getSceneY();
				final MenuEntry entry = new MenuEntry("", "", 10008, 21, param0, param1, false);
				this.menuEntrySwapHandler.AB1CaddDEdaHI12361JKLM8NO3ka5gw(entry);
				this.bool2 = false;
				this.instant2 = Instant.now();
			}, this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw(), TimeUnit.MILLISECONDS);
		}
		else
		{
			this.VWXcdefghi3FGYZ13Ab3558933gHIJKLM8NO3.remove(0);
		}
	}

	private void s6641asgn2kd1dasgha1333()
	{
		Duration retryTime;
		Duration var2;
		if (this.instant1 != null)
		{
			retryTime = Duration.ofMillis(this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw() + 500L);
			var2 = Duration.between(this.instant1, Instant.now());
			if (var2.compareTo(retryTime) >= 0)
			{
				this.bool2 = true;
				this.instant1 = null;
			}
		}

		if (this.instant2 != null && !this.bool2)
		{
			retryTime = Duration.ofMillis((long) DeadZoneUtilities.jkld2369IJgha561gkkbcFdaw1fa5def(3000, 4000) + this.deadZoneUtilities.AB1CaddDEdaHI12361JKLM8NO3ka5gw());
			var2 = Duration.between(this.instant2, Instant.now());
			if (var2.compareTo(retryTime) >= 0)
			{
				LOGGER.info("Detected failure, resetting!");
				this.bool2 = true;
				this.instant1 = null;
				this.instant2 = null;
			}
		}

	}
}
