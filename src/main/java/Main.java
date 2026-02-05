class Main {
  public static void main(String[] args) {
   public static boolean ex1(TreeNode<Range> t) {

    if (t == null) {
        return true;
    }

    Range r = t.getValue();
    int low = r.getLow();
    int high = r.getHigh();

    if (t.hasLeft()) {
        Range rLeft = t.getLeft().getValue();
        int lowLeft = rLeft.getLow();
        int highLeft = rLeft.getHigh();

        if (low <= lowLeft && high >= highLeft) {
            return false;
        }
    }

    if (t.hasRight()) {
        Range rRight = t.getRight().getValue();
        int lowRight = rRight.getLow();
        int highRight = rRight.getHigh();

        if (highRight == high && lowRight > low) {
            return false;
        }
    }

    if (t.hasRight() && t.hasLeft()) {
        if (t.getLeft().getValue().getHigh() >=
            t.getRight().getValue().getLow()) {
            return false;
        }
    }

    return ex1(t.getLeft()) && ex1(t.getRight());
}
  }
}
