class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        start=image[sr][sc]
        self.dfs(image,sr,sc,color,start)

        return image

    def dfs(self,image,sr,sc,color,start):

        if sr<0 or sr>len(image)-1 or sc<0 or sc>len(image[0])-1 or image[sr][sc]==color or image[sr][sc] != start:
            return
        
        image[sr][sc]=color
        self.dfs(image,sr+1,sc,color,start)
        self.dfs(image,sr-1,sc,color,start)
        self.dfs(image,sr,sc+1,color,start)
        self.dfs(image,sr,sc-1,color,start)
