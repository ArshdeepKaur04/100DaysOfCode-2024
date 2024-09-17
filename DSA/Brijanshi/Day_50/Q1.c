#include <stdio.h>

int findDays(int *weights, int size, int cap) {
    int days = 1, load = 0;
    for(int i = 0; i < size; i++) {
        if(weights[i] + load > cap) {
            days++;
            load = weights[i];
        }
        else {
            load += weights[i];
        }
    }
    return days;
}

int shipWithinDays(int *weights, int size, int days) {
    int low = weights[0];
    for(int i = 1; i < size; i++) {
        if(weights[i] > low) {
            low = weights[i];
        }
    }

    int high = 0;
    for(int i = 0; i < size; i++) {
        high += weights[i];
    }

    while(low <= high) {
        int mid = (low + high) / 2;
        int numberOfDays = findDays(weights, size, mid);
        if (numberOfDays <= days) {
            high = mid - 1;
        }
        else {
            low = mid + 1;
        }
    }
    return low;
}

int main() {
    int size, days;
    printf("Enter the number of packages: ");
    scanf("%d", &size);
    printf("Enter the number of days: ");
    scanf("%d", &days);

    int *weights = (int *)malloc(size * sizeof(int));
    printf("Enter the weights of the packages:\n");
    for(int i = 0; i < size; i++) {
        scanf("%d", &weights[i]);
    }

    int result = shipWithinDays(weights, size, days);
    printf("The least weight capacity of the ship is: %d\n", result);

    free(weights);
    return 0;
}
