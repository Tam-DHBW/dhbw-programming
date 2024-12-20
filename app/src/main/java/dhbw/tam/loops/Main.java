package dhbw.tam.loops;

class Main {
    public static void main(String[] args) {
        System.out.println("Tree:");
        printTree();
        System.out.println("Matrix Addition");
        matrixElementWise();
        System.out.println("Matrix Transpose");
        transposeMatrix();
        System.out.println("Matrix multiplication");
        multiplyMatrix();
    }

    static String buildSymmetricalLine(char c, int radius, int maxRadius) {
        String empty = " ".repeat(maxRadius - radius);
        String opaque = String.valueOf(c).repeat(radius);

        return empty + opaque + c + opaque + empty;
    }

    static void printTree() {
        final int maxRadius = 5;
        final int trunkHeight = 3;
        final int trunkRadius = 2;

        for (int radius = 0; radius <= maxRadius; radius++) {
            char c = radius == 0 ? '+' : '*';
            System.out.println(Main.buildSymmetricalLine(c, radius, maxRadius));
        }

        for (int trunkRow = 0; trunkRow < trunkHeight; trunkRow++) {
            System.out.println(Main.buildSymmetricalLine('*', trunkRadius, maxRadius));
        }
    }

    static void printMatrix(int[][] mat) {
        for (int row = 0; row < mat.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < mat[row].length; col++) {
                System.out.print(mat[row][col]);
                System.out.print("\t");
            }
            System.out.println(" |");
        }
    }

    static void matrixElementWise() {
        int[][] A = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        int[][] B = {
                { 7, 8, 9 },
                { 10, 11, 12 }
        };

        int rows = A.length;
        int cols = A[0].length;
        int[][] C = new int[rows][cols];

        // Element-wise addition
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                C[row][col] = A[row][col] + B[row][col];
            }
        }

        // Print result matrix
        printMatrix(C);
    }

    static void transposeMatrix() {
        int[][] A = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        int rows = A.length;
        int cols = A[0].length;
        int[][] T = new int[cols][rows];

        // Transpose logic
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                T[col][row] = A[row][col];
            }
        }

        // Print transposed matrix
        printMatrix(T);
    }

    static void multiplyMatrix() {
        int[][] A = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        int[][] B = {
                { 7, 8 },
                { 9, 10 },
                { 11, 12 }
        };

        // Result matrix
        int rowsA = A.length; // Number of rows in A
        int colsA = A[0].length; // Number of columns in A
        int colsB = B[0].length; // Number of columns in B
        int[][] C = new int[rowsA][colsB];

        // Matrix multiplication
        for (int colB = 0; colB < colsB; colB++) {
            for (int rowA = 0; rowA < rowsA; rowA++) {
                int sum = 0;
                for (int colA = 0; colA < colsA; colA++) {
                    sum += A[rowA][colA] * B[colA][colB];
                }
                C[rowA][colB] = sum;
            }
        }

        // Print result matrix
        printMatrix(C);
    }
}
