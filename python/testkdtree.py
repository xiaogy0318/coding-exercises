from kdtree import KDTree

data = [(1,2,3),(4,0,1),(5,3,1),(10,5,4),(9,8,9),(4,2,4)]

tree = KDTree.construct_from_data(data)
nearest = tree.query(query_point=(5,4,3), t=2)
print nearest