package net.twc.eschaton.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.twc.eschaton.Eschaton;
import net.twc.eschaton.entity.custom.RiftSpearProjectileEntity;

public class RiftSpearProjectileModel extends EntityModel<RiftSpearProjectileEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Eschaton.MOD_ID, "rift_spear"), "main");
    private final ModelPart rift_spear;

    public RiftSpearProjectileModel(ModelPart root) {
        this.rift_spear = root.getChild("rift_spear");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition rift_spear = partdefinition.addOrReplaceChild("rift_spear", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition blade_r1 = rift_spear.addOrReplaceChild("blade_r1", CubeListBuilder.create().texOffs(8, 14).addBox(7.0536F, -1.9749F, -1.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0251F, -11.5536F, 0.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition tip_r1 = rift_spear.addOrReplaceChild("tip_r1", CubeListBuilder.create().texOffs(5, 20).addBox(7.6368F, 7.6722F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0251F, -11.5536F, 0.0F, 0.0F, 0.0F, -2.3562F));

        PartDefinition cloth_r1 = rift_spear.addOrReplaceChild("cloth_r1", CubeListBuilder.create().texOffs(8, 4).addBox(-3.5F, -5.0F, 0.0F, 7.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, -15.9932F, 0.0F, 3.1416F, 3.1416F, 2.3562F));

        PartDefinition cube_r1 = rift_spear.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 0).addBox(-3.5251F, 3.9876F, 3.9876F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0251F, -11.5536F, 0.0F, -0.7854F, 0.0F, -3.1416F));

        PartDefinition handle_r1 = rift_spear.addOrReplaceChild("handle_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0251F, -12.9464F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0251F, -11.5536F, 0.0F, 0.0F, 0.0F, -3.1416F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(RiftSpearProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        rift_spear.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
