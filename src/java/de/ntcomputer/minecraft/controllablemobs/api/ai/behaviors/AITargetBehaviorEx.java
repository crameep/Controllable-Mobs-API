package de.ntcomputer.minecraft.controllablemobs.api.ai.behaviors;

import net.minecraft.server.v1_5_R3.EntityLiving;

import org.bukkit.entity.LivingEntity;

import de.ntcomputer.minecraft.controllablemobs.implementation.ControllableMobHelper;

/**
 * Base class for target behavior with extended arguments.
 * Implementation of these behaviors are using a custom core.
 * 
 * @author Cybran
 * @version 53
 *
 */
public abstract class AITargetBehaviorEx extends AITargetBehavior {
	protected final int maximumNoEyeContactTicks;
	protected final boolean ignoreInvulnerability;
	protected final float maximumDistance;
	protected final Class<? extends EntityLiving>[] targetClasses;

	@SuppressWarnings("unchecked")
	protected AITargetBehaviorEx(final int priority, final int maximumNoEyeContactTicks, final boolean ignoreInvulnerability, final float maximumDistance, final Class<? extends LivingEntity>[] targetClasses) throws IllegalArgumentException {
		super(priority);
		if(targetClasses==null) throw new IllegalArgumentException("targetClasses must not be null");
		if(targetClasses.length==0) throw new IllegalArgumentException("targetClasses must not be empty");
		this.maximumNoEyeContactTicks = maximumNoEyeContactTicks;
		this.ignoreInvulnerability = ignoreInvulnerability;
		this.maximumDistance = maximumDistance;
		this.targetClasses = new Class[targetClasses.length];
		for(int i=0; i<targetClasses.length; i++) {
			this.targetClasses[i] = (Class<? extends EntityLiving>) ControllableMobHelper.getNotchEntityClass(targetClasses[i]);
		}
	}

}