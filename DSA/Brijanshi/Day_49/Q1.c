#include <stdio.h>

int rowWithMax1s(int **arr, int row_size, int col_size) {
    int i = 0, j = col_size - 1, ans = -1;
    
    while(i < row_size && j >= 0) {
        if(!(arr[i][j])) {
            i++;
        }
        else {
            ans = i;
            j--;
        }
    }
    
    return ans;
}

int main() {
    int row_size, col_size;
    printf("Enter the number of rows: ");
    scanf("%d", &row_size);
    printf("Enter the number of columns: ");
    scanf("%d", &col_size);
    
    int **arr = (int **)malloc(row_size * sizeof(int *));
    for(int i = 0; i < row_size; i++) {
        arr[i] = (int *)malloc(col_size * sizeof(int));
    }
    
    printf("Enter the elements of the 2D array:\n");
    for(int i = 0; i < row_size; i++) {
        for(int j = 0; j < col_size; j++) {
            scanf("%d", &arr[i][j]);
        }
    }
    
    int result = rowWithMax1s(arr, row_size, col_size);
    printf("The index of the first row with the most number of 1s is: %d\n", result);
    
    for(int i = 0; i < row_size; i++) {
        free(arr[i]);
    }
    free(arr);
    
    return 0;
}
