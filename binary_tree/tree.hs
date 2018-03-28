module Tree where

data BinaryTree tree = Null | Node tree (BinaryTree tree) (BinaryTree tree)
    deriving (Show, Eq)
preOrder :: BinaryTree tree -> [tree]
preOrder Null = []
preOrder (Node content left right) = [content] ++ preOrder left ++ (preOrder right)

postOrder :: BinaryTree tree -> [tree]
postOrder Null = []
postOrder (Node content left right) = postOrder left ++ postOrder right ++ [content]

inOrder :: BinaryTree tree -> [tree]
inOrder Null = []
inOrder (Node content left right) = inOrder left ++ [content] ++ inOrder right

maxi :: Int -> Int -> Int
maxi x y = if x > y then x
              else y

absolute :: Int -> Int
absolute x = if x > 0 then x
              else 0 - x

calculateTreeHeight :: BinaryTree tree -> Int
calculateTreeHeight Null = 0
calculateTreeHeight (Node content left right) = 1 + maxi (calculateTreeHeight left) (calculateTreeHeight right)

insertTree :: (Ord a) => BinaryTree a -> a -> BinaryTree a
insertTree Null a = Node a Null Null
insertTree (Node a left right) b
    | b == a = Node a left right
    | b < a = Node a (insertTree left b) right
    | b > a = Node a left (insertTree right b)


isBalancedTree:: BinaryTree tree -> Bool
isBalancedTree Null = True
isBalancedTree (Node content left right) = (absolute ( (calculateTreeHeight left) - (calculateTreeHeight right)) ) <= 1 && (isBalancedTree left) && (isBalancedTree right)
