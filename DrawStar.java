public class DrawStar implements Activity {
    private Communicator io;
    int levelNo;

    public DrawStar(Communicator communicator) {
        io = communicator;
    }

    public void run() throws TypeQException {

        boolean isAlignLeft = true;
        boolean isTopSide = true;

        io.tell("Press 1 to have left aligned, 0 to have right aligned triangle");
        int alignLeft = io.listenInt();

        if (alignLeft == 0)
            isAlignLeft = false;
            
        io.tell("Press 1 to have topside, 0 to have reverse triangle");
        int topSide = io.listenInt();

        if (topSide == 0)
            isTopSide = false;

        io.tell("How many level does your triangle");
        int levelNo = io.listenInt();
        if (levelNo == 0)
            return;

        io.tell("Draw triangle fonksiyonu çizimi :");
        drawTriangle(levelNo, isAlignLeft, isTopSide);


        /*io.tell("ayrı fonksiyonların çizimi :");

        if (alignLeft == 1 && topSide == 1) {
            drawLeftAlignedTriangle(levelNo);
        }
        if (alignLeft == 0 && topSide == 1) {
            drawRighttAlignedTriangle(levelNo);
        }
        if (alignLeft == 1 && topSide == 0) {
            drawLeftAlignedReverseTriangle(levelNo);
        }
        if (alignLeft == 0 && topSide == 0) {
            drawRightAlignedReverseTriangle(levelNo);
        }*/

    }

    public void drawTriangle(int levelNo, boolean isLeftAligned, boolean isTopSide) {
        int count;
        int eCount;

        if (isTopSide) {
            count = 0;
            eCount = levelNo;
        } else {
            count = levelNo;
            eCount = 0;
        }
        for (int i = 0; i <= levelNo; i++) {
            if (!isLeftAligned) {
                for (int k = 0; k < eCount; k++) {
                    io.print(" ");
                }
            }
            for (int j = 0; j < count; j++) {
                io.print("*");
            }
            if (isTopSide) {
                count++;
                eCount--;
            } else {
                count--;
                eCount++;
            }

            io.print("\n");
        }
    }

    /*public void drawLeftAlignedTriangle(int levelNo) {
        int count = 0;
        boolean isLeftAligned = true;
        int eCount = levelNo;

        for (int i = 0; i < levelNo; i++) {
            count++;
            for (int j = 0; j < count; j++) {
                if (!isLeftAligned) {
                    for (int k = 0; k < eCount; k++) {
                        io.print(" ");
                    }
                }
                io.print("*");

            }
            io.print("\n");
        }
    }

    public void drawRighttAlignedTriangle(int levelNo) {
        int count = 0;
        int eCount = levelNo;
        for (int i = 0; i <= levelNo; i++) {
            for (int k = 0; k < eCount; k++) {
                io.print(" ");
            }
            for (int j = 0; j < count; j++) {
                io.print("*");
            }
            count++;
            eCount--;
            io.print("\n");
        }
    }

    public void drawLeftAlignedReverseTriangle(int levelNo) {
        int count = levelNo;
        for (int i = 0; i <= levelNo; i++) {
            for (int j = 0; j < count; j++) {
                io.print("*");
            }
            count--;
            io.print("\n");
        }
    }

    public void drawRightAlignedReverseTriangle(int levelNo) {
        int count = levelNo;
        int eCount = 0;
        for (int i = 0; i <= levelNo; i++) {
            for (int k = 0; k < eCount; k++) {
                io.print(" ");
            }
            for (int j = 0; j < count; j++) {
                io.print("*");
            }
            count--;
            eCount++;
            io.print("\n");
        }
    }*/

    @Override
    public String getName() {
        return "Draw Star";
    }

}
