package com.example.beeapplicationframework.objects;

/**
 * Created by Jackson on 2/24/2017.
 */

public class BeedexTree {

    public BeedexNode affinisNode = new BeedexNode("Bombus affinis", "Rusty-patched bumble bee", "affinis",
            "griseocollis, bimaculatus",
            "April - October",
            "This bumble bee has a half black, half yellow abdomen with a thin orange stripe in the top half." +
                    " It has a black dot and gray coloring on the thorax and is dark around the wings.");
    public BeedexNode bimaculatusNode = new BeedexNode("Bombus bimaculatus", "Two-spotted bumble bee", "bimaculatus",
            "impatiens, griseocollis",
            "April - October",
            "This bumble bee has a black dot on the thorax, is dark around the wings and has a mostly black abdomen. " +
                    "The top half of the abdomen typically, has an irregular band in the middle of the abdomen.");
    public BeedexNode fervidusNode = new BeedexNode("Bombus fervidus", "Yellow bumble bee", "fervidus",
            "-",
            "May - October",
            "This bumble bee has a mostly yellow abdomen, with a small portion of black at the bottom of the abdomen. " +
                    "The thorax has a black band going across the middle.");
    public BeedexNode griseocollisNode = new BeedexNode("Bombus griseocollis", "Brown-belted bumble bee", "griseocollis",
            "bimaculatus, affinis, impatiens",
            "May - October",
            "This bumble bee has a black dot on the thorax, is dark around the wings and has a thin orange band before the " +
                    "abdomen becomes mostly black.");
    public BeedexNode impatiensNode = new BeedexNode("Bombus impatiens", "Common Eastern bumble bee", "impatiens",
            "bimaculatus, griseocollis",
            "April - October",
            "This bumble bee is dark around the wings, has a gray coloring to the thorax and has a mostly black abdomen.");
    public BeedexNode pennsylvanicusNode = new BeedexNode("Bombus pennsylvanicus", "American bumble bee", "pennsylvanicus",
            "terricola",
            "May - October",
            "This bumble bee has a mostly yellow abdomen. The bottom of the abdomen is always black and occasionally, there " +
                    "is a thin black coloring at the top of the abdomen, extending down from the thorax. The thorax is typically " +
                    "dark, either being all black or having a distinct black band surrounded by gray coloring.");
    public BeedexNode perplexusNode = new BeedexNode("Bombus perplexus", "Confusing bumble bee", "perplexus",
            "vagans",
            "April - September",
            "This bumble bee has a half black abdomen. Occasionally, the black band is irregular. The thorax is yellow with " +
                    "darkening around the wings.");
    public BeedexNode ternariusNode = new BeedexNode("Bombus ternarius", "Tri-colored bumble bee", "ternarius",
            "-",
            "April - October",
            "This bumble bee has a thick orange strip on the abdomen. The thorax has black band in the middle and may have " +
                    "a black triangle below the band as well.");
    public BeedexNode terricolaNode = new BeedexNode("Bombus terricola", "Yellow-banded bumble bee", "terricola",
            "pennsylvanicus",
            "April - October",
            "This bumble bee has a half black abdomen. The top and bottom ends of the abdomen are typically black, with yellow in " +
                    "between the two bands. Top of the abdomen has a black band as well.");
    public BeedexNode vagansNode = new BeedexNode("Bombus vagans", "Half-black bumble bee", "vagans",
            "perplexus",
            "April - October",
            "This bumble bee has a half black abdomen, with the bottom half always being black. The abdomen has a " +
                    "black dot surrounded by a gray coloring and dark around the wings.");

    public BeedexTree() {
    }

    // Retrieves correct node based off a string input
    public BeedexNode getNode(String s) {
        switch(s) {
            case "affinis":
                return this.affinisNode;
            case "bimaculatus":
                return this.bimaculatusNode;
            case "fervidus":
                return this.fervidusNode;
            case "griseocollis":
                return this.griseocollisNode;
            case "impatiens":
                return this.impatiensNode;
            case "pennsylvanicus":
                return this.pennsylvanicusNode;
            case "perplexus":
                return this.perplexusNode;
            case "ternarius":
                return this.ternariusNode;
            case "terricola":
                return this.terricolaNode;
            case "vagans":
                return this.vagansNode;
            default:
                return new BeedexNode("I AM ERROR", "-", "robbee_rotten", "-", "-", "-");
        }
    }

}
