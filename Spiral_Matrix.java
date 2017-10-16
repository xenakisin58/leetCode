class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(matrix == null || matrix.length==0){
            return ans;
        }
        int cols = matrix.length;
        int rows = matrix[0].length;
        int x=0,y=0;
        while(cols>0 && rows>0){
            if(cols==1){
                for(int i=0;i<rows;i++){
                    ans.add(matrix[x][y++]);
                }
                break;
            }
            if(rows==1){
                for(int i=0;i<cols;i++){
                    ans.add(matrix[x++][y]);
                }
                break;
            }
            for(int i=0;i<rows-1;i++){
                ans.add(matrix[x][y++]);
            }
            for(int i=0;i<cols-1;i++){
                ans.add(matrix[x++][y]);
            }
            for(int i=0;i<rows-1;i++){
                ans.add(matrix[x][y--]);
            }
            for(int i=0;i<cols-1;i++){
                ans.add(matrix[x--][y]);
            }
            y++;
            x++;
            cols-=2;
            rows-=2;
        }
        return ans;
    }
}
