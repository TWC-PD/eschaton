package net.twc.eschaton.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.twc.eschaton.Eschaton;
import net.twc.eschaton.entity.custom.RiftSpearProjectileEntity;

public class RiftSpearProjectileRenderer extends EntityRenderer<RiftSpearProjectileEntity> {
    private RiftSpearProjectileModel model;

    public RiftSpearProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new RiftSpearProjectileModel(pContext.bakeLayer(RiftSpearProjectileModel.LAYER_LOCATION));
    }

    @Override
    public void render(RiftSpearProjectileEntity pEntity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(buffer, this.model.renderType(this.getTextureLocation(pEntity)),false, pEntity.isFoil());
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(pEntity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(RiftSpearProjectileEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Eschaton.MOD_ID, "textures/entity/spear/rift/rift_spear.png");
    }
}
